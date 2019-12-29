package org.bomber.api.dto.schema

import org.bomber.api.dto.schema.GeneratorConfigDTO

data class RequestParamDTO(
    val name: String,
    val isGeneratorNeed: Boolean,
    val value: String?,
    val generator: String?,
    val config: GeneratorConfigDTO?
)