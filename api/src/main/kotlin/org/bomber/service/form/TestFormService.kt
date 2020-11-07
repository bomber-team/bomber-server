package org.bomber.service.form

import org.bomber.api.dto.form.TestFormDto
import org.bomber.api.dto.form.TestFormStatusDto
import org.bomber.api.dto.requests.CreateTestFormRequest
import org.bomber.api.dto.requests.UpdateTestFormRequest
import org.bomber.converter.dto.form.TestFormDtoConverter
import org.bomber.exception.RestSchemaNotFoundException
import org.bomber.exception.RestScriptNotFoundException
import org.bomber.model.form.TestForm
import org.bomber.model.form.TestFormStatus
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
        schemaRepository.getSchema(request.schemaId) ?: throw RestSchemaNotFoundException(request.schemaId)

        val form = TestForm(
            id = UUID.randomUUID().toString(),
            name = request.name,
            status = TestFormStatus.NEW,
            schemaId = request.schemaId,
            scriptId = request.scriptId,
            version = null
        )

        return repository.save(form).let {
            TestFormDtoConverter.convert(it)
        }
    }

    fun update(request: UpdateTestFormRequest): TestFormDto {

    }

    fun get(formId: String): TestFormDto {

    }

    fun run(formId: String): TestFormDto {

    }

    fun delete(formId: String) {

    }
}