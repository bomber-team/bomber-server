package org.bomber.api.dto.requests

import org.bomber.api.dto.schema.RequestParamDTO

data class CreateRestSchemaRequest(
    val pathVariables: Map<String, String>,
    val headers: Map<String, String>,
    val requestParams: List<RequestParamDTO>,
    val body: String
)

data class UpdateRestSchemaRequest(
    val pathVariables: Map<String, String>?,
    val headers: Map<String, String>?,
    val requestParams: List<RequestParamDTO>?,
    val body: String?
)