package bomber.dto.script

sealed class ScriptDTO

data class RestScript(
    val id: String,
    val schemeId: String,
    val name: String,
    val address: String,
    val requestMethod: String,
    val configuration: RestConfigurationDTO
) : ScriptDTO()