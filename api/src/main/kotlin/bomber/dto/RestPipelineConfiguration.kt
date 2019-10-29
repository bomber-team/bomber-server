package bomber.dto

data class RestPipelineConfiguration(
    val replay: Long,
    val replayAfterFailed: Boolean,
    val replayAfterTimeout: Long
)