package bomber.dto.scenario

data class RestScenarioPipelineDTO(
    val stages: List<RestScenario>,
    val configuration: RestPipelineConfigurationDTO
)