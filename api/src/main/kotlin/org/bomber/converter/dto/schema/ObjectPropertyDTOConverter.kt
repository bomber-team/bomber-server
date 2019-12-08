package org.bomber.converter.dto.schema

import org.bomber.dto.schema.ObjectPropertyDTO
import org.bomber.model.schema.ObjectProperty
import org.springframework.core.convert.converter.Converter

object ObjectPropertyDTOConverter : Converter<ObjectProperty, ObjectPropertyDTO> {
    override fun convert(source: ObjectProperty): ObjectPropertyDTO {
        return ObjectPropertyDTO(
            name = source.name,
            isGenerated = source.isGenerated,
            generatorType = source.generatorType?.let {
                GeneratorTypeDTOConverter.convert(it)
            },
            config = source.config?.let {
                GeneratorConfigDTOConverter.convert(it)
            },
            properties = source.properties.mapValues { BodyParamDTOConverter.convert(it.value) }
        )
    }
}