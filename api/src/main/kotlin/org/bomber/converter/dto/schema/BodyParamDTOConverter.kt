package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.BodyParamDTO
import org.bomber.model.schema.BodyParam
import org.bomber.model.schema.ListProperty
import org.bomber.model.schema.ObjectProperty
import org.bomber.model.schema.SimpleProperty
import org.springframework.core.convert.converter.Converter

object BodyParamDTOConverter : Converter<BodyParam, BodyParamDTO> {

    override fun convert(source: BodyParam): BodyParamDTO {
        return when (source) {
            is SimpleProperty<*> -> SimplePropertyDTOConverter.convert(source)
            is ListProperty<*> -> ListPropertyDTOConverter.convert(source)
            is ObjectProperty -> ObjectPropertyDTOConverter.convert(source)
        }
    }
}