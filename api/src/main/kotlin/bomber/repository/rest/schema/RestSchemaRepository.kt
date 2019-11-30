package bomber.repository.rest.schema

import bomber.model.schema.RestSchema

interface RestSchemaRepository {
    suspend fun saveSchema(restSchema: RestSchema): RestSchema

    suspend fun getSchema(id: String): RestSchema?

    suspend fun getSchemas(): List<RestSchema>

    suspend fun deleteScheme(id: String): RestSchema?
}