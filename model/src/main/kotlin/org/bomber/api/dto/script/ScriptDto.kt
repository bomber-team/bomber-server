package org.bomber.api.dto.script

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping
import io.swagger.v3.oas.annotations.media.Schema

@Schema(
    name = "Script",
    oneOf = [RestScriptDto::class],
    discriminatorProperty = "type",
    discriminatorMapping = [
        DiscriminatorMapping("REST", schema = RestScriptDto::class)]
)
@JsonTypeInfo(property = "type", use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes(
    JsonSubTypes.Type(RestScriptDto::class)
)
sealed class ScriptDto(
    val type: ScriptTypeDto
)

@Schema(name = "RestScript")
data class RestScriptDto(
    val id: String,
    val name: String,
    val address: String,
    val requestMethod: String,
    val configuration: RestConfigurationDto
) : ScriptDto(ScriptTypeDto.REST)

enum class ScriptTypeDto {
    REST
}