package org.bomber.api.dto.requests

data class CreateTestFormRequest(
    val name: String,
    val schemaId: String,
    val scriptId: String
)

data class UpdateTestFormRequest(
    val name: String,
    val schemaId: String,
    val scriptId: String
)