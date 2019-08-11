package org.springframework.cloud.config.server.arango.config

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
     TODO("Not implemented")
    }
}