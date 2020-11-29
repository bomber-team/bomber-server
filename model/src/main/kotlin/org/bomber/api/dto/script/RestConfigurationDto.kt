package org.bomber.api.dto.script

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "RestConfiguration")
data class RestConfigurationDto(
    val requestAmount: Int
)