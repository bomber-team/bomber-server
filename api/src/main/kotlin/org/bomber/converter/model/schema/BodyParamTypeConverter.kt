package org.bomber.converter.model.schema

import org.bomber.api.dto.schema.BodyParamTypeDto
import org.bomber.model.schema.BodyParamType
import org.springframework.core.convert.converter.Converter

object BodyParamTypeConverter : Converter<BodyParamTypeDto, BodyParamType> {
    override fun convert(source: BodyParamTypeDto): BodyParamType {
        return when (source) {
            BodyParamTypeDto.SIMPLE_PROPERTY -> BodyParamType.SIMPLE_PROPERTY
            BodyParamTypeDto.LIST -> BodyParamType.LIST
            BodyParamTypeDto.OBJECT -> BodyParamType.OBJECT
        }
    }
}