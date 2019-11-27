package bomber.dto.requests

import bomber.dto.script.RestPipelineConfigurationDTO

data class CreateScriptPipeline(
    val stages: List<String>,
    val configuration: RestPipelineConfigurationDTO
)

data class UpdateScriptPipeline(
    val stages: List<String>,
    val configuration: RestPipelineConfigurationDTO
)