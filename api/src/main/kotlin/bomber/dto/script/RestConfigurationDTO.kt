package bomber.dto.script

data class RestConfigurationDTO(
    val amountRequest: Long,
    val timeoutOneRequest: Long,
    val timeBetweenAttacks: Long,
    val notifyAfterComplete: Boolean,
    val sendMetrics: Boolean,
    val logging: Boolean,
    val useGeneratedCach: Boolean
)
