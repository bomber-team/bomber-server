package bomber.service.rest.script

import bomber.dto.requests.CreateScriptRequest
import bomber.dto.script.RestScriptDTO
import bomber.dto.script.RestScriptItemsDTO
import org.springframework.stereotype.Service

/**
 * @author Konstantin Volivach
 *
 */
@Service
class ScriptServiceImpl : ScriptService {
    override suspend fun createScript(request: CreateScriptRequest): RestScriptDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun updateScript(updateRequest: RestScriptDTO): RestScriptDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getScript(id: String): RestScriptDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getScriptAll(
        limit: Int,
        offset: Int
    ): RestScriptItemsDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteScript(id: String): RestScriptDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}