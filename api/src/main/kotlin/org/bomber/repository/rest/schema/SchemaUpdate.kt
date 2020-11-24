package org.bomber.repository.rest.schema

import org.bomber.model.schema.RequestParam

data class SchemaUpdate(
    val pathVariables: Map<String, String>,
    val headers: Map<String, String>,
    val requestParams: List<RequestParam>,
    val body: String
)