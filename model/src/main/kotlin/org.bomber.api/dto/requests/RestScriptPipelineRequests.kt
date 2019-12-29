package org.bomber.api.dto.requests

import org.bomber.api.dto.script.RestPipelineConfigurationDTO

data class CreateScriptPipeline(
    val stages: List<String>,
    val configuration: RestPipelineConfigurationDTO
)

data class UpdateScriptPipeline(
    val stages: List<String>,
    val configuration: RestPipelineConfigurationDTO
)