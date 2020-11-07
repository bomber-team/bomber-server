package org.bomber.service.form

import org.bomber.api.dto.form.TestFormDto
import org.bomber.api.dto.requests.CreateTestFormRequest
import org.bomber.api.dto.requests.UpdateTestFormRequest
import org.bomber.model.form.TestForm
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
        val script = scriptRepository.get(request.scriptId) ?: TODO("Exception")
        val schema = schemaRepository.getSchema(request.schemaId)?: TODO("Exception")

        val form = TestForm(
            id = UUID.randomUUID().toString(),
            name = request.name,
            schemaId = request.schemaId,
            scriptId = request.scriptId,
            version = null
        )

        return repository.save(form)?.let {

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