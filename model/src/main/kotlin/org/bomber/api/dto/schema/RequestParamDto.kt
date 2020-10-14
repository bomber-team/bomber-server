package org.bomber.api.dto.schema

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "RequestParam")
data class RequestParamDto(
    val name: String,
    val isGeneratorNeed: Boolean,
    val value: String?,
    val generator: String?,
    val config: GeneratorConfigDto?
)