package org.springframework.cloud.config.server.arango.environment

import org.springframework.cloud.config.environment.Environment
import org.springframework.cloud.config.server.environment.EnvironmentRepository

/**
 * Implementation of {@link EnvironmentRepository} that is backed by arangodb.
 * @author kostya05983
 */
class ArangoEnvironmentRepository: EnvironmentRepository {

    companion object {
        private const val LABEL = "label"
        private const val PROFILE = "profile"
        private const val DEFAULT = "default"
    }

    /**
     * Logic for select scheme or scenario for bomber
     */
    override fun findOne(application: String?, profile: String?, label: String?): Environment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}