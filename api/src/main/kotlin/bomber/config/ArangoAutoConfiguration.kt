package bomber.config

import com.arangodb.ArangoDB
import com.arangodb.springframework.config.ArangoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties

@ConditionalOnProperty(prefix = "org.bomber.team.arango", name = ["enabled"], havingValue = "true")
@EnableConfigurationProperties(ArangoProperties::class)
class ArangoAutoConfiguration : ArangoConfiguration {
    override fun arango(): ArangoDB.Builder {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun database(): String {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}