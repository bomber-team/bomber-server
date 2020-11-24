package org.bomber.service.rest.script

import org.bomber.api.dto.requests.CreateScriptRequest
import org.bomber.api.dto.requests.UpdateScriptRequest
import org.bomber.api.dto.script.RestScriptDto
import org.bomber.api.dto.script.RestScriptItemsDTO

interface RestScriptService {
    suspend fun create(request: CreateScriptRequest): RestScriptDto

    suspend fun update(id: String, request: UpdateScriptRequest): RestScriptDto

    suspend fun get(id: String): RestScriptDto

    suspend fun getAll(
        take: Long,
        skip: Int
    ): RestScriptItemsDTO

    suspend fun delete(id: String)
}