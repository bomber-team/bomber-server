package org.bomber.config.arango

import org.springframework.boot.context.properties.ConfigurationProperties

internal const val BOMBER_TEAM_ARANGO = "org.bomber.team.arango"

@ConfigurationProperties(BOMBER_TEAM_ARANGO)
data class ArangoProperties(
    var enabled: Boolean = false,
    var host: String? = null,
    var database: String? = null
)