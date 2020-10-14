package org.bomber.api.dto.script

data class RestScriptPipelineDTO(
    val id: String,
    val stages: List<RestScriptDto>,
    val configuration: RestPipelineConfigurationDTO
)