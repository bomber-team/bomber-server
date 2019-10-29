package bomber.dto.schema

data class RequestParamDTO(
    val name: String,
    val isGeneratorNeed: String,
    val value: String?,
    val generator: String?,
    val config: GeneratorConfigDTO?
)