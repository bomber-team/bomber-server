package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.BodyParamTypeDTO
import org.bomber.model.schema.BodyParamType
import org.springframework.core.convert.converter.Converter

object BodyParamTypeDTOConverter : Converter<BodyParamType, BodyParamTypeDTO> {
    override fun convert(source: BodyParamType): BodyParamTypeDTO {
        return when (source) {
            BodyParamType.SIMPLE_PROPERTY -> BodyParamTypeDTO.SIMPLE_PROPERTY
            BodyParamType.LIST -> BodyParamTypeDTO.LIST
            BodyParamType.OBJECT -> BodyParamTypeDTO.OBJECT
        }
    }
}