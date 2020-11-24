package org.bomber.service.rest.schema

import org.bomber.api.dto.requests.CreateRestSchemaRequest
import org.bomber.api.dto.requests.UpdateRestSchemaRequest
import org.bomber.api.dto.schema.RestSchemaDTO
import org.bomber.api.dto.schema.RestSchemaItemsDto

interface RestSchemaService {
    suspend fun create(request: CreateRestSchemaRequest): RestSchemaDTO

    suspend fun update(id: String, request: UpdateRestSchemaRequest): RestSchemaDTO

    suspend fun get(id: String): RestSchemaDTO

    suspend fun getAll(offset: Long, limit: Int): RestSchemaItemsDto

    suspend fun delete(id: String)
}