package org.bomber.service.rest.script

import org.bomber.converter.dto.script.RestScriptDTOConverter
import org.bomber.converter.model.RestConfigurationConverter
import org.bomber.api.dto.requests.CreateScriptRequest
import org.bomber.api.dto.requests.UpdateScriptRequest
import org.bomber.api.dto.script.RestScriptDto
import org.bomber.api.dto.script.RestScriptItemsDTO
import org.bomber.exception.RestScriptNotFoundException
import org.bomber.exception.RestScriptUpdateException
import org.bomber.model.script.RestScript
import org.bomber.repository.rest.script.RestScriptRepository
import org.bomber.repository.rest.script.UpdateScript
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author Konstantin Volivach
 *
 */
@Service
class RestScriptServiceImpl(
    private val repository: RestScriptRepository
) : RestScriptService {
    override suspend fun create(request: CreateScriptRequest): RestScriptDto {
        val model = RestScript(
            id = UUID.randomUUID().toString(),
            name = request.name,
            address = request.address,
            requestMethod = request.requestMethod,
            configuration = RestConfigurationConverter.convert(request.configuration)
        )

        val result = repository.save(model)

        return RestScriptDTOConverter.convert(result)
    }

    override suspend fun update(id: String, request: UpdateScriptRequest): RestScriptDto {
        val updateScript = UpdateScript(
            name = request.name,
            address = request.address,
            requestMethod = request.requestMethod,
            configuration = RestConfigurationConverter.convert(request.configuration)
        )
        return repository.update(id, updateScript)?.let {
            RestScriptDTOConverter.convert(it)
        } ?: throw RestScriptUpdateException(id)
    }

    override suspend fun get(id: String): RestScriptDto {
        val restScript = repository.get(id)
            ?: throw RestScriptNotFoundException(id)
        return RestScriptDTOConverter.convert(restScript)
    }

    override suspend fun getAll(
        take: Long,
        skip: Int
    ): RestScriptItemsDTO {
        val scripts = repository.getAll()
        return RestScriptItemsDTO(
            items = scripts.map { RestScriptDTOConverter.convert(it) }
        )
    }

    override suspend fun delete(id: String) {
        repository.delete(id) ?: throw RestScriptNotFoundException(id)
    }
}