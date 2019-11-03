package bomber.dto.schema

sealed class SchemaDTO

data class RestSchemaDTO(
    val id: String,
    val pathVariables: Map<String, String>,
    val headers: Map<String, String>,
    val requestParams: List<RequestParamDTO>,
    val body: List<BodyParamDTO>
) : SchemaDTO()