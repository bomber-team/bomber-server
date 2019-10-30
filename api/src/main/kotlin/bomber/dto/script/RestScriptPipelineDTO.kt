package bomber.dto.script

data class RestScriptPipelineDTO(
    val id: String,
    val stages: List<RestScript>,
    val configuration: RestPipelineConfigurationDTO
)