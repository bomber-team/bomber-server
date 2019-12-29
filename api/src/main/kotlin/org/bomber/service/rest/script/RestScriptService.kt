package org.bomber.service.rest.script

import org.bomber.api.dto.requests.CreateScriptRequest
import org.bomber.api.dto.requests.UpdateScriptRequest
import org.bomber.api.dto.script.RestScriptDTO
import org.bomber.api.dto.script.RestScriptItemsDTO

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