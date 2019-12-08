package org.bomber.converter.model.schema

import org.bomber.dto.schema.BodyParamDTO
import org.bomber.dto.schema.ListPropertyDTO
import org.bomber.dto.schema.ObjectPropertyDTO
import org.bomber.dto.schema.SimplePropertyDTO
import org.bomber.model.schema.BodyParam
import org.springframework.core.convert.converter.Converter

object BodyParamConverter : Converter<BodyParamDTO, BodyParam> {
    override fun convert(source: BodyParamDTO): BodyParam {
        return when (source) {
            is SimplePropertyDTO<*> -> SimplePropertyConverter.convert(source)
            is ListPropertyDTO<*> -> TODO()
            is ObjectPropertyDTO -> ObjectPropertyConverter.convert(source)
        }
    }
}