package org.springframework.cloud.config.server.arango.config

import com.arangodb.ArangoDBAsync
import org.springframework.cloud.config.server.arango.environment.ArangoEnvironmentRepository
import org.springframework.cloud.config.server.environment.EnvironmentRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author kostya05983
 * Configuration class for configurations with arangodb
 */
@Configuration
public class ArangoEnvironmentRepositoryConfiguration {

    @Bean
    public fun environmentRepository(): EnvironmentRepository {
        val arangoDbAsync = ArangoDBAsync.Builder().host("localhost", 8529).build() //TODO make arango autowired
        return ArangoEnvironmentRepository(arangoDbAsync)
    }
}