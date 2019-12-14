package org.bomber.service.rest.script

import org.bomber.dto.requests.CreateScriptRequest
import org.bomber.dto.requests.UpdateScriptRequest
import org.bomber.dto.script.RestScriptDTO
import org.bomber.dto.script.RestScriptItemsDTO

interface RestScriptService {
    suspend fun createScript(request: CreateScriptRequest): RestScriptDTO

    suspend fun updateScript(updateRequest: UpdateScriptRequest): RestScriptDTO

    suspend fun getScript(id: String): RestScriptDTO

    suspend fun getScriptAll(
        limit: Int,
        offset: Int
    ): RestScriptItemsDTO

    suspend fun deleteScript(id: String): RestScriptDTO
}