package org.bomber.api.dto.schema

sealed class BodyParamDTO(
    val name: String,
    val type: BodyParamTypeDto,
    val isGenerated: Boolean?,
    val config: GeneratorConfigDto?
)

class SimplePropertyDTO<T>(
    name: String,
    type: BodyParamTypeDto,
    isGenerated: Boolean?,
    config: GeneratorConfigDto?,
    val value: T
) : BodyParamDTO(
    name,
    type,
    isGenerated,
    config
)

class ListPropertyDTO<T>(
    name: String,
    isGenerated: Boolean?,
    config: GeneratorConfigDto?,
    val value: List<SimplePropertyDTO<T>>
) : BodyParamDTO(
    name,
    type = BodyParamTypeDto.LIST,
    isGenerated = isGenerated,
    config = config
)

class ObjectPropertyDTO(
    name: String,
    isGenerated: Boolean?,
    config: GeneratorConfigDto?,
    val properties: Map<String, BodyParamDTO>
) : BodyParamDTO(
    name,
    type = BodyParamTypeDto.OBJECT,
    isGenerated = isGenerated,
    config = config
)