package org.bomber.repository.rest.schema

import org.bomber.model.schema.RestSchema

interface RestSchemaRepository {
    suspend fun saveSchema(restSchema: RestSchema): RestSchema

    suspend fun getSchema(id: String): RestSchema?

    suspend fun getSchemas(): List<RestSchema>

    suspend fun deleteScheme(id: String): Long?
}