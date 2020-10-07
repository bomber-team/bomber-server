package org.bomber.repository.rest.script

import com.arangodb.entity.DocumentUpdateEntity
import com.arangodb.model.DocumentDeleteOptions
import com.arangodb.model.DocumentUpdateOptions
import com.arangodb.springframework.core.ArangoOperations
import org.bomber.model.script.RestScript
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RestScriptRepositoryImpl(
    private val arangoTemplate: ArangoOperations
) : RestScriptRepository {
    private val logger = LoggerFactory.getLogger(javaClass)

    override suspend fun save(restScript: RestScript): RestScript {
        val result = arangoTemplate.insert(restScript)
        logger.debug("Insert script with $result")
        return restScript
    }

    override suspend fun update(id: String, update: UpdateScript): RestScript? {
        val options = DocumentUpdateOptions()
        options.returnNew(true)
        val entity = arangoTemplate.update(id, update, options)
        return (entity as? DocumentUpdateEntity<RestScript>)?.new
    }

    override suspend fun get(id: String): RestScript? {
        val result = arangoTemplate.find(id, RestScript::class.java)
        return result.orElse(null)
    }

    override suspend fun getAll(): List<RestScript> {
        val result = arangoTemplate.findAll(RestScript::class.java)
        return result.toList()
    }

    override suspend fun delete(id: String): Long? {
        val options = DocumentDeleteOptions()
        options.waitForSync(true)
        val result = arangoTemplate.delete(id, RestScript::class.java, options)
        return if (result == null) {
            null
        } else {
            1
        }
    }
}