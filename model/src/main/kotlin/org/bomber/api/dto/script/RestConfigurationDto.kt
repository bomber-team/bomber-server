package org.bomber.api.dto.script

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "RestConfiguration")
data class RestConfigurationDto(
    val amountRequest: Long,
    val timeoutForOneRequest: Long,
    val timeBetweenAttacks: Long,
    val notifyAfterComplete: Boolean,
    val sendMetrics: Boolean,
    val logging: Boolean,
    val useGeneratedCache: Boolean
)