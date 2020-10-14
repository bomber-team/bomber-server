package org.bomber.api.dto.requests

import org.bomber.api.dto.schema.RequestParamDto

data class CreateRestSchemaRequest(
    val pathVariables: Map<String, String>,
    val headers: Map<String, String>,
    val requestParams: List<RequestParamDto>,
    val body: String
)

data class UpdateRestSchemaRequest(
    val pathVariables: Map<String, String>?,
    val headers: Map<String, String>?,
    val requestParams: List<RequestParamDto>?,
    val body: String?
)