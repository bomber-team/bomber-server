package bomber.dto.script

sealed class ScriptDTO

data class RestScript(
    val name: String,
    val scheme: String,
    val address: String,
    val requestMethod: String,
    val configuration: RestConfigurationDTO
) : ScriptDTO()