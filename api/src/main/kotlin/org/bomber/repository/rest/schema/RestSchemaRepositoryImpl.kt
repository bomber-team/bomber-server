package org.bomber.repository.rest.schema

import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.bomber.model.schema.RestSchema
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Component

@Component
class RestSchemaRepositoryImpl(
    private val template: ReactiveMongoTemplate
) : RestSchemaRepository {
    override suspend fun save(restSchema: RestSchema): RestSchema {
        return template.save(restSchema).awaitFirst()
    }

    override suspend fun update(id: String, update: SchemaUpdate): RestSchema? {
        TODO("Not yet implemented")
    }

    override suspend fun get(id: String): RestSchema? {
        val criteria = Criteria.where(RestSchema::id.name).isEqualTo(id)
        val query = Query().addCriteria(criteria)

        return template.find(query, RestSchema::class.java).awaitFirstOrNull()
    }

    override suspend fun getAll(filter: SchemaFilter): List<RestSchema> {
        val query = Query().limit(filter.take).skip(filter.skip)
        return template.find(query, RestSchema::class.java).collectList().awaitFirst()
    }

    override suspend fun delete(id: String): Long? {
        val criteria = Criteria.where(RestSchema::id.name).isEqualTo(id)
        val query = Query().addCriteria(criteria)

        return template.remove(query, RestSchema::class.java).awaitFirstOrNull()?.deletedCount
    }
}