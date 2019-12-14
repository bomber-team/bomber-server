package org.bomber.service.rest.script

import org.bomber.converter.dto.script.RestScriptDTOConverter
import org.bomber.converter.model.RestConfigurationConverter
import org.bomber.dto.requests.CreateScriptRequest
import org.bomber.dto.requests.UpdateScriptRequest
import org.bomber.dto.script.RestScriptDTO
import org.bomber.dto.script.RestScriptItemsDTO
import org.bomber.exception.RestScriptNotFoundException
import org.bomber.model.script.RestScript
import org.bomber.repository.rest.script.RestScriptRepository
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author Konstantin Volivach
 *
 */
@Service
class RestScriptServiceImpl(
    private val restScriptRepository: RestScriptRepository
) : RestScriptService {
    override suspend fun createScript(request: CreateScriptRequest): RestScriptDTO {
        val model = RestScript(
            id = UUID.randomUUID().toString(),
            schemeId = request.schemeId,
            name = request.name,
            address = request.address,
            requestMethod = request.requestMethod,
            configuration = RestConfigurationConverter.convert(request.configuration)
        )

        val result = restScriptRepository.saveScript(model)

        return RestScriptDTOConverter.convert(result)
    }

    override suspend fun updateScript(updateRequest: UpdateScriptRequest): RestScriptDTO {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getScript(id: String): RestScriptDTO {
        val restScript = restScriptRepository.getScript(id)
            ?: throw RestScriptNotFoundException(id)
        return RestScriptDTOConverter.convert(restScript)
    }

    override suspend fun getScriptAll(
        limit: Int,
        offset: Int
    ): RestScriptItemsDTO {
        val scripts = restScriptRepository.getScripts()
        return RestScriptItemsDTO(
            items = scripts.map { RestScriptDTOConverter.convert(it) }
        )
    }

    override suspend fun deleteScript(id: String): RestScriptDTO {
        val result = restScriptRepository.deleteScript(id)
            ?: throw RestScriptNotFoundException(id)
        return RestScriptDTOConverter.convert(result)
    }
}