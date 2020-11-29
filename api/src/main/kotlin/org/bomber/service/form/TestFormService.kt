package org.bomber.service.form

import org.bomber.api.dto.form.TestFormDto
import org.bomber.api.dto.form.TestFormItemsDto
import org.bomber.api.dto.requests.CreateTestFormRequest
import org.bomber.api.dto.requests.UpdateTestFormRequest
import org.bomber.converter.dto.form.TestFormDtoConverter
import org.bomber.exception.*
import org.bomber.model.form.*
import org.bomber.repository.form.FormUpdate
import org.bomber.repository.form.FormsFilter
import org.bomber.repository.form.TestFormRepository
import org.bomber.repository.rest.schema.RestSchemaRepository
import org.bomber.repository.rest.script.RestScriptRepository
import org.bomber.suppliers.TaskSource
import org.bomber.team.contracts.Scheme
import org.bomber.team.contracts.Script
import org.bomber.team.contracts.TaskProto
import org.springframework.stereotype.Component
import java.util.*

@Component
class TestFormService(
    private val repository: TestFormRepository,
    private val schemaRepository: RestSchemaRepository,
    private val scriptRepository: RestScriptRepository,
    private val taskSource: TaskSource
) {
    suspend fun create(request: CreateTestFormRequest): TestFormDto {
        scriptRepository.get(request.scriptId) ?: throw RestScriptNotFoundException(request.scriptId)
        schemaRepository.get(request.schemeId) ?: throw RestSchemaNotFoundException(request.schemeId)

        val form = TestForm(
            id = UUID.randomUUID().toString(),
            name = request.name,
            status = TestFormStatus.READY,
            schemaId = request.schemeId,
            scriptId = request.scriptId,
            version = null,
            event = null
        )

        return repository.save(form).let {
            TestFormDtoConverter.convert(it)
        }
    }

    suspend fun update(formId: String, request: UpdateTestFormRequest): TestFormDto {
        scriptRepository.get(request.scriptId) ?: throw RestScriptNotFoundException(request.scriptId)
        schemaRepository.get(request.schemeId) ?: throw RestSchemaNotFoundException(request.schemeId)
        val update = FormUpdate(
            name = request.name,
            scriptId = request.scriptId,
            schemaId = request.schemeId,
            status = TestFormStatus.READY
        )

        return repository.update(formId, update)?.let {
            TestFormDtoConverter.convert(it)
        } ?: throw TestFormUpdateException(formId)
    }

    suspend fun get(formId: String): TestFormDto {
        return repository.get(formId)?.let {
            TestFormDtoConverter.convert(it)
        } ?: throw TestFormNotFoundException(formId)
    }

    suspend fun getAll(take: Int, skip: Long): TestFormItemsDto {
        val filter = FormsFilter(
            take = take,
            skip = skip
        )
        return TestFormItemsDto(
            items = repository.getAll(filter).map { TestFormDtoConverter.convert(it) }
        )
    }

    suspend fun run(formId: String): TestFormDto {
        val form = repository.get(formId) ?: throw TestFormNotFoundException(formId)
        if (form.status != TestFormStatus.READY) throw TestFormWrongStatusException(formId)
        val update = FormUpdate(
            status = TestFormStatus.IN_PROGRESS,
            event = FormDomainEvent(
                actions = listOf(
                    RunFormAction(
                        schemaId = form.schemaId,
                        scriptId = form.scriptId
                    )
                )
            )
        )
        val result = repository.update(formId, update)?.let {
            TestFormDtoConverter.convert(it)
        } ?: throw TestFormUpdateException(formId)


        val scriptModel = scriptRepository.get(form.scriptId) ?: throw RestScriptNotFoundException(form.scriptId)
        val schemeModel = schemaRepository.get(form.schemaId) ?: throw RestSchemaNotFoundException(form.schemaId)
        val requestAmount = scriptModel.configuration.requestAmount

        val requestsPerBomber = requestAmount / BOMBER_AMOUNT

        val tasks = (0..4).map {
            val protoScript = Script.RestScript.newBuilder()
                .setAddress(scriptModel.address)
                .setRequestMethod(scriptModel.requestMethod)
                .setSchemeId(form.schemaId)
                .setConfig(
                    Script.ConfigurationScript.newBuilder().setRps(
                        scriptModel.configuration.rps.toLong()
                    ).setTime(
                        requestsPerBomber / scriptModel.configuration.rps.toLong()
                    ).build()
                ).build()
            val protoScheme = Scheme.RestSchema.newBuilder().setId(
                schemeModel.id
            )

            for (requestParam in schemeModel.requestParams) {
                protoScheme.addRequest(
                    Scheme.RequestParam.newBuilder()
                        .setValue(requestParam.value).setName(requestParam.name)
                        .setIsGeneratorNeed(requestParam.isGeneratorNeed)
                        .build()
                )
            }

            TaskProto.Task.newBuilder()
                .setFormId(formId)
                .setScript(
                    protoScript
                ).setSchema(protoScheme.build())
                .build()
        }
        tasks.forEach { taskSource.add(it) }
        // TODO неидемпотентное место, переделать затем)
        return result
    }

    suspend fun delete(formId: String) {
        val form = repository.get(formId) ?: throw TestFormNotFoundException(formId)
        if (form.status == TestFormStatus.IN_PROGRESS) throw TestFormWrongStatusException(formId)
        repository.delete(form.id)
    }

    private companion object {
        const val BOMBER_AMOUNT = 4;
    }
}