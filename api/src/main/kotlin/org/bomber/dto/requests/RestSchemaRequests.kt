package org.bomber.dto.requests

import org.bomber.dto.schema.BodyParamDTO
import org.bomber.dto.schema.RequestParamDTO

data class CreateRestSchemaRequest(
    val pathVariables: Map<String, String>,
    val headers: Map<String, String>,
    val requestParams: List<RequestParamDTO>,
    val body: List<BodyParamDTO>?
)

data class UpdateRestSchemaRequest(
    val pathVariables: Map<String, String>?,
    val headers: Map<String, String>?,
    val requestParams: List<RequestParamDTO>?,
    val body: List<BodyParamDTO>?
)