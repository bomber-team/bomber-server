package org.bomber.model.script

data class RestConfiguration(
    val amountRequest: Long,
    val timeoutForOneRequest: Long,
    val timeBetweenAttacks: Long,
    val notifyAfterComplete: Boolean,
    val sendMetrics: Boolean,
    val logging: Boolean,
    val useGeneratedCache: Boolean
)
