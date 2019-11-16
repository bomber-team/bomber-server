package bomber.models.schema

sealed class Schema

data class RestSchema(
    val id: String,
    val pathVariables: Map<String, String>,
    val headers: Map<String, String>,
    val requestParams: List<RequestParam>,
    val body: List<BodyParam>
) : Schema()