package org.bomber.service.form

import org.bomber.api.dto.form.TestFormDto
import org.bomber.api.dto.requests.CreateTestFormRequest
import org.bomber.api.dto.requests.UpdateTestFormRequest
import org.bomber.converter.dto.form.TestFormDtoConverter
import org.bomber.exception.*
import org.bomber.model.form.*
import org.bomber.repository.form.FormUpdate
import org.bomber.repository.form.TestFormRepository
import org.bomber.repository.rest.schema.RestSchemaRepository
import org.bomber.repository.rest.script.RestScriptRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class TestFormService(
    private val repository: TestFormRepository,
    private val schemaRepository: RestSchemaRepository,
    private val scriptRepository: RestScriptRepository
) {
    suspend fun create(request: CreateTestFormRequest): TestFormDto {
        scriptRepository.get(request.scriptId) ?: throw RestScriptNotFoundException(request.scriptId)
        schemaRepository.get(request.schemaId) ?: throw RestSchemaNotFoundException(request.schemaId)

        val form = TestForm(
            id = UUID.randomUUID().toString(),
            name = request.name,
            status = TestFormStatus.READY,
            schemaId = request.schemaId,
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
        schemaRepository.get(request.schemaId) ?: throw RestSchemaNotFoundException(request.schemaId)
        val update = FormUpdate(
            name = request.name,
            scriptId = request.scriptId,
            schemaId = request.schemaId,
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
        return repository.update(formId, update)?.let {
            TestFormDtoConverter.convert(it)
        } ?: throw TestFormUpdateException(formId)
    }

    suspend fun delete(formId: String) {
        val form = repository.get(formId) ?: throw TestFormNotFoundException(formId)
        if (form.status == TestFormStatus.IN_PROGRESS) throw TestFormWrongStatusException(formId)
        repository.delete(form.id)
    }
}