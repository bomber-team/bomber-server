package bomber.model.script

data class RestScriptPipeline(
    val id: String,
    val stages: List<RestScript>,
    val configuration: RestPipelineConfiguration
)