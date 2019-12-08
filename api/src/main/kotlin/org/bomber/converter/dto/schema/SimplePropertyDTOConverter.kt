package org.bomber.converter.dto.schema

import org.bomber.dto.schema.SimplePropertyDTO
import org.bomber.model.schema.SimpleProperty
import org.springframework.core.convert.converter.Converter

object SimplePropertyDTOConverter : Converter<SimpleProperty<*>, SimplePropertyDTO<*>> {
    override fun convert(source: SimpleProperty<*>): SimplePropertyDTO<*> {
        return SimplePropertyDTO(
            name = source.name,
            type = BodyParamTypeDTOConverter.convert(source.type),
            isGenerated = source.isGenerated,
            generatorType = source.generatorType?.let {
                GeneratorTypeDTOConverter.convert(it)
            },
            config = source.config?.let { GeneratorConfigDTOConverter.convert(it) },
            value = source.value
        )
    }
}