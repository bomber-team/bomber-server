package org.bomber.model.script

data class RestPipelineConfiguration(
    val replay: Long,
    val replayAfterFailed: Boolean,
    val replayAfterTimeout: Long
)