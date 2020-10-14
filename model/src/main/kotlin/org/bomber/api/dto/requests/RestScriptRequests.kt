package org.bomber.api.dto.requests

import org.bomber.api.dto.script.RestConfigurationDto

data class CreateScriptRequest(
    val schemeId: String,
    val name: String,
    val address: String,
    val requestMethod: String,
    val configuration: RestConfigurationDto
)

data class UpdateScriptRequest(
    val name: String,
    val address: String,
    val requestMethod: String,
    val configuration: RestConfigurationDto
)