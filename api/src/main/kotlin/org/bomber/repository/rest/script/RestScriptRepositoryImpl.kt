package org.bomber.repository.rest.script

import org.bomber.model.script.RestScript
import com.arangodb.springframework.core.template.ArangoTemplate
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RestScriptRepositoryImpl(
    private val arangoTemplate: ArangoTemplate
) : RestScriptRepository {
    private val logger = LoggerFactory.getLogger(javaClass)

    override suspend fun saveScript(restScript: RestScript): RestScript {
        val result = arangoTemplate.insert(restScript)
        logger.debug("Insert script with $result")
        return restScript
    }

    override suspend fun getScript(id: String): RestScript? {
        val result = arangoTemplate.find(id, RestScript::class.java)
        return result.orElse(null)
    }

    override suspend fun getScripts(): List<RestScript> {
        val result = arangoTemplate.findAll(RestScript::class.java)
        return result.toList()
    }

    // TODO rewrite
    override suspend fun deleteScript(id: String): RestScript? {
        val entity = arangoTemplate.find(id, RestScript::class.java)
        val result = arangoTemplate.delete(id, RestScript::class.java)
        return if (result != null) {
            entity.orElse(null)
        } else {
            null
        }
    }
}