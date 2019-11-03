package bomber.service.rest.script

import bomber.dto.requests.CreateScriptRequest
import bomber.dto.script.RestScriptDTO
import bomber.dto.script.RestScriptItemsDTO

interface ScriptService {
    suspend fun createScript(request: CreateScriptRequest): RestScriptDTO

    suspend fun updateScript(updateRequest: RestScriptDTO): RestScriptDTO

    suspend fun getScript(id: String): RestScriptDTO

    suspend fun getScriptAll(
        limit: Int,
        offset: Int
    ): RestScriptItemsDTO

    suspend fun deleteScript(id: String): RestScriptDTO
}