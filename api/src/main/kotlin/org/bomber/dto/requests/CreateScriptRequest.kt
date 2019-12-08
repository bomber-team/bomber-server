package org.bomber.dto.requests

import org.bomber.dto.script.RestConfigurationDTO

data class CreateScriptRequest(
    val schemeId: String,
    val name: String,
    val address: String,
    val requestMethod: String,
    val configuration: RestConfigurationDTO
)