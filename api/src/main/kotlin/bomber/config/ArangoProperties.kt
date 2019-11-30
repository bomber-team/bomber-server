package bomber.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("org.bomber.team.arango")
data class ArangoProperties(
    var enabled: Boolean = false,
    var host: String,
    var database: String
)