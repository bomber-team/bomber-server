package bomber.dto.script

data class RestScriptPipelineDTO(
    val id: String,
    val stages: List<RestScriptDTO>,
    val configuration: RestPipelineConfigurationDTO
)