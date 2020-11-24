package org.bomber.repository.rest.script

import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.bomber.model.script.RestScript
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Component

@Component
class RestScriptRepositoryImpl(
    private val template: ReactiveMongoTemplate
) : RestScriptRepository {
    private val logger = LoggerFactory.getLogger(javaClass)

    override suspend fun save(restScript: RestScript): RestScript {
        return template.save(restScript).awaitFirst()
    }

    override suspend fun update(id: String, update: UpdateScript): RestScript? {
        val criteria = Criteria.where(RestScript::id.name).isEqualTo(id)

        val query = Query().addCriteria(criteria)
        val update = Update().apply {
            update.address?.let {
                set(RestScript::address.name, it)
            }
            update.configuration?.let {
                set(RestScript::configuration.name, it)
            }
            update.name?.let {
                set(RestScript::name.name, it)
            }
            update.requestMethod?.let {
                set(RestScript::requestMethod.name, it)
            }
        }

        val options = FindAndModifyOptions().returnNew(true)
        return template.findAndModify(query, update, options, RestScript::class.java).awaitFirstOrNull()
    }

    override suspend fun get(id: String): RestScript? {
        val criteria = Criteria.where(RestScript::id.name).isEqualTo(id)
        val query = Query().addCriteria(criteria)

        return template.find(query, RestScript::class.java).awaitFirstOrNull()
    }

    override suspend fun getAll(): List<RestScript> {
        return template.findAll(RestScript::class.java).collectList().awaitFirst()
    }

    override suspend fun delete(id: String): Long? {
        val criteria = Criteria.where(RestScript::id.name).isEqualTo(id)
        val query = Query().addCriteria(criteria)

        return template.remove(query, RestScript::class.java).awaitFirstOrNull()?.let { it.deletedCount }
    }
}