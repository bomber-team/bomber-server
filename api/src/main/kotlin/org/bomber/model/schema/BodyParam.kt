package org.bomber.model.schema

sealed class BodyParam(
    val name: String,
    val type: BodyParamType,
    val isGenerated: Boolean?,
    val config: GeneratorConfig?
)

class SimpleProperty<T>(
    name: String,
    type: BodyParamType,
    isGenerated: Boolean?,
    config: GeneratorConfig?,
    val value: T
) : BodyParam(
    name,
    type,
    isGenerated,
    config
)

class ListProperty<T>(
    name: String,
    isGenerated: Boolean?,
    config: GeneratorConfig?,
    val value: List<SimpleProperty<T>>
) : BodyParam(
    name,
    type = BodyParamType.LIST,
    isGenerated = isGenerated,
    config = config
)

class ObjectProperty(
    name: String,
    isGenerated: Boolean?,
    config: GeneratorConfig?,
    val properties: Map<String, BodyParam>
) : BodyParam(
    name,
    type = BodyParamType.OBJECT,
    isGenerated = isGenerated,
    config = config
)