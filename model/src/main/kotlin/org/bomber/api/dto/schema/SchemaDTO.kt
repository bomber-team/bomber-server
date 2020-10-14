package org.bomber.api.dto.schema

sealed class SchemaDTO

data class RestSchemaDTO(
    val id: String,
    val pathVariables: Map<String, String>,
    val headers: Map<String, String>,
    val requestParams: List<RequestParamDto>,
    val body: String
) : SchemaDTO()