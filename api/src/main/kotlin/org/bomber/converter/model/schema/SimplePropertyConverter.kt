package org.bomber.converter.model.schema

import org.bomber.api.dto.schema.SimplePropertyDTO
import org.bomber.model.schema.SimpleProperty
import org.springframework.core.convert.converter.Converter

object SimplePropertyConverter : Converter<SimplePropertyDTO<*>, SimpleProperty<*>> {
    override fun convert(source: SimplePropertyDTO<*>): SimpleProperty<*> {
        return SimpleProperty(
            name = source.name,
            type = BodyParamTypeConverter.convert(source.type),
            isGenerated = source.isGenerated,
            config = source.config?.let { GeneratorConfigConverter.convert(it) },
            value = source.value
        )
    }
}