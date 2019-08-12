package org.springframework.cloud.config.server.arango.environment

import com.arangodb.ArangoDBAsync
import com.arangodb.entity.BaseDocument
import com.arangodb.util.MapBuilder
import org.springframework.cloud.config.environment.Environment
import org.springframework.cloud.config.environment.PropertySource
import org.springframework.cloud.config.server.environment.EnvironmentRepository
import java.util.stream.Collectors

/**
 * Implementation of {@link EnvironmentRepository} that is backed by arangodb.
 * @author kostya05983
 */
class ArangoEnvironmentRepository(private val arangodb: ArangoDBAsync) : EnvironmentRepository {

    companion object {
        private const val BOMBER_ID = "bomber_id"
        private const val COLLECTION = "collection"
    }

    /**
     * Logic for select scheme or scenario for bomber
     */
    override fun findOne(application: String?, profile: String?, label: String?): Environment {
        val db = arangodb.db(application)
        val async = db.query("FOR document in $profile return document", BaseDocument::class.java).get()
        val configList = async.streamRemaining().collect(Collectors.toList())

        val environment = Environment(application, profile, null, null, null)
        for (document in configList) {
            val sourceName = document.getAttribute(BOMBER_ID).toString()
            val propSource = PropertySource(sourceName, document.properties)
            environment.add(propSource)
        }
        return environment
    }
}