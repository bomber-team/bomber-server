package bomber.repository

import bomber.models.schema.RestSchema

interface RestSchemaRepository {
    suspend fun saveSchema(restSchema: RestSchema): RestSchema

    suspend fun getSchema(id: String): RestSchema?
}