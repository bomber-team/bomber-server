package org.bomber.converter.model.schema

import org.bomber.api.dto.schema.ObjectPropertyDTO
import org.bomber.model.schema.ObjectProperty
import org.springframework.core.convert.converter.Converter

object ObjectPropertyConverter : Converter<ObjectPropertyDTO, ObjectProperty> {
    override fun convert(source: ObjectPropertyDTO): ObjectProperty {
        return ObjectProperty(
            name = source.name,
            isGenerated = source.isGenerated,
            config = source.config?.let { GeneratorConfigConverter.convert(it) },
            properties = source.properties.mapValues { BodyParamConverter.convert(it.value) }
        )
    }
}