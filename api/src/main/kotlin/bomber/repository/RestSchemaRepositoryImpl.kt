package bomber.repository

import bomber.models.schema.RestSchema
import com.arangodb.springframework.core.ArangoOperations
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RestSchemaRepositoryImpl(
    private val arangoTemplate: ArangoOperations
) : RestSchemaRepository {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override suspend fun saveSchema(restSchema: RestSchema): RestSchema {
        val result = arangoTemplate.insert(restSchema)
        logger.debug("Insert restSchema, result log=$result")
        return restSchema
    }

    override suspend fun getSchema(id: String): RestSchema? {
        val result = arangoTemplate.find(id, RestSchema::class.java)
        return result.orElse(null)
    }
}