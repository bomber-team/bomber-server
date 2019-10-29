package bomber.dto.schema

sealed class BodyParamDTO(
    val name: String,
    val type: BodyParamTypeDTO,
    val isGenerated: Boolean?,
    val generatorType: GeneratorTypeDTO?,
    val config: GeneratorConfigDTO?
)

class SimpleBodyParamDTO<T>(
    name: String,
    type: BodyParamTypeDTO,
    isGenerated: Boolean?,
    generatorType: GeneratorTypeDTO?,
    config: GeneratorConfigDTO?,
    val value: T
) : BodyParamDTO(
    name,
    type,
    isGenerated,
    generatorType,
    config
)

class ListPropertyDTO<T>(
    name: String,
    isGenerated: Boolean?,
    generatorType: GeneratorTypeDTO?,
    config: GeneratorConfigDTO?,
    val value: List<SimpleBodyParamDTO<T>>
) : BodyParamDTO(
    name,
    type = BodyParamTypeDTO.LIST,
    isGenerated = isGenerated,
    config = config,
    generatorType = generatorType
)

class ObjectPropertyDTO(
    name: String,
    isGenerated: Boolean?,
    generatorType: GeneratorTypeDTO?,
    config: GeneratorConfigDTO?,
    val properties: Map<String, BodyParamDTO>
) : BodyParamDTO(
    name,
    type = BodyParamTypeDTO.OBJECT,
    isGenerated = isGenerated,
    config = config,
    generatorType = generatorType
)