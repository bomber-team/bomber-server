package bomber.dto.scenario

import org.codehaus.jackson.annotate.JsonProperty

data class RestConfigurationDTO(
    val amountRequest: Long,
    @field: JsonProperty("timeout_one_request")
    val timeoutOneRequest: Long,
    val timeBetweenAttacks: Long,
    val notifyAfterComplete: Boolean,
    val sendMetrics: Boolean,
    val logging: Boolean,
    val useGeneratedCach: Boolean
)
