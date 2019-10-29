package bomber.dto

data class RestScenarioPipeline(
    val stages: List<RestScenario>,
    val configuration: RestPipelineConfiguration
)