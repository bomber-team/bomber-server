package org.bomber.api.dto.script

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "RestScriptItems")
data class RestScriptItemsDTO(
    val items: List<RestScriptDto>
)