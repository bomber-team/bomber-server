package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.BodyParamTypeDto
import org.bomber.model.schema.BodyParamType
import org.springframework.core.convert.converter.Converter

object BodyParamTypeDTOConverter : Converter<BodyParamType, BodyParamTypeDto> {
    override fun convert(source: BodyParamType): BodyParamTypeDto {
        return when (source) {
            BodyParamType.SIMPLE_PROPERTY -> BodyParamTypeDto.SIMPLE_PROPERTY
            BodyParamType.LIST -> BodyParamTypeDto.LIST
            BodyParamType.OBJECT -> BodyParamTypeDto.OBJECT
        }
    }
}