package bomber.dto

import org.codehaus.jackson.annotate.JsonProperty

data class RestConfiguration(
    val amountRequest: Long,
    @field: JsonProperty("timeout_one_request")
    val timeoutOneRequest: Long,
    val timeBetweenAttacks: Long,
    val notifyAfterComplete: Boolean,
    val sendMetrics: Boolean,
    val logging: Boolean,
    val useGeneratedCach: Boolean
)
