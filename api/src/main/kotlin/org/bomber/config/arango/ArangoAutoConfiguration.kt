package org.bomber.config.arango

import com.arangodb.ArangoDB
import com.arangodb.springframework.annotation.EnableArangoRepositories
import com.arangodb.springframework.config.ArangoConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties

@ConditionalOnProperty(prefix = BOMBER_TEAM_ARANGO, name = ["enabled"], havingValue = "true")
@EnableConfigurationProperties(ArangoProperties::class)
@EnableArangoRepositories(basePackages = ["bomber"])
class ArangoAutoConfiguration : ArangoConfiguration {
    @Autowired
    private lateinit var arangoProperties: ArangoProperties

    override fun arango(): ArangoDB.Builder {
        val builder = ArangoDB.Builder()
        builder.host(
            arangoProperties.host,
            DEFAULT_TCP_PORT
        )
        return builder
    }

    override fun database(): String {
        return requireNotNull(arangoProperties.database)
    }

    private companion object {
        const val DEFAULT_TCP_PORT = 8529
    }
}