package bomber.dto

sealed class ScenarioDTO

data class RestScenario(
        val retry: String
) : ScenarioDTO()