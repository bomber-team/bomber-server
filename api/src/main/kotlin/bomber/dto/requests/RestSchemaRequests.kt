package bomber.dto.requests

import bomber.dto.schema.BodyParamDTO
import bomber.dto.schema.RequestParamDTO

data class CreateRestSchemaRequest(
    val pathVariables: Map<String, String>,
    val headers: Map<String, String>,
    val requestParams: List<RequestParamDTO>,
    val body: List<BodyParamDTO>
)

data class UpdateRestSchemaRequest(
    val pathVariables: Map<String, String>?,
    val headers: Map<String, String>?,
    val requestParams: List<RequestParamDTO>?,
    val body: List<BodyParamDTO>?
)