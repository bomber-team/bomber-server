package bomber.repository

import bomber.models.schema.RestSchema
import com.arangodb.springframework.core.template.ArangoTemplate

class RestSchemaRepositoryImpl(
    private val arangoTemplate: ArangoTemplate
) : RestSchemaRepository {

    override suspend fun saveSchema(restSchema: RestSchema): RestSchema {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSchema(id: String): RestSchema? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}