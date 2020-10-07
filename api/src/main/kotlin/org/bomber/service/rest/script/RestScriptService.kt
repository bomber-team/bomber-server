package org.bomber.service.rest.script

import org.bomber.api.dto.requests.CreateScriptRequest
import org.bomber.api.dto.requests.UpdateScriptRequest
import org.bomber.api.dto.script.RestScriptDTO
import org.bomber.api.dto.script.RestScriptItemsDTO

interface RestScriptService {
    suspend fun create(request: CreateScriptRequest): RestScriptDTO

    suspend fun update(id: String, request: UpdateScriptRequest): RestScriptDTO

    suspend fun get(id: String): RestScriptDTO

    suspend fun getAll(
        limit: Int,
        offset: Int
    ): RestScriptItemsDTO

    suspend fun delete(id: String): Unit
}