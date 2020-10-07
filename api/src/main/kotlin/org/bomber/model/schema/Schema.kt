package org.bomber.model.schema

import com.arangodb.springframework.annotation.Document

sealed class Schema

@Document(value = "jsonRestSchema")
data class RestSchema(
    val id: String,
    val pathVariables: Map<String, String>,
    val headers: Map<String, String>,
    val requestParams: List<RequestParam>,
    val body: String
) : Schema()