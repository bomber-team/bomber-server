package org.bomber.service.rest.schema

import org.bomber.api.dto.requests.CreateRestSchemaRequest
import org.bomber.api.dto.requests.UpdateRestSchemaRequest
import org.bomber.api.dto.schema.RestSchemaDTO
import org.bomber.api.dto.schema.RestSchemaItemsDTO

interface RestSchemaService {

    suspend fun createSchema(request: CreateRestSchemaRequest): RestSchemaDTO

    suspend fun updateSchema(id: String, request: UpdateRestSchemaRequest): RestSchemaDTO

    suspend fun getSchema(id: String): RestSchemaDTO

    suspend fun getSchemes(offset: Int, limit: Int): RestSchemaItemsDTO

    suspend fun deleteSchema(id: String): RestSchemaDTO
}