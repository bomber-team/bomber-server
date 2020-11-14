package org.bomber.repository.rest.schema

import org.bomber.model.schema.RestSchema

interface RestSchemaRepository {
    suspend fun save(restSchema: RestSchema): RestSchema

    suspend fun get(id: String): RestSchema?

    suspend fun getAll(filter: SchemaFilter): List<RestSchema>

    suspend fun delete(id: String): Long?
}