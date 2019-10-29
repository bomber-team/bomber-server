package bomber.dto

sealed class ScenarioDTO

data class RestScenario(
    val name: String,
    val scheme: String,
    val address: String,
    val requestMethod: String,
    val configuration: RestConfiguration
) : ScenarioDTO()