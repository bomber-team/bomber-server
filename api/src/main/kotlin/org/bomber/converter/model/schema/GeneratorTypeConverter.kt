package org.bomber.converter.model.schema

import org.bomber.api.dto.schema.GeneratorTypeDTO
import org.bomber.model.schema.GeneratorType
import org.springframework.core.convert.converter.Converter

object GeneratorTypeConverter : Converter<GeneratorTypeDTO, GeneratorType> {
    override fun convert(source: GeneratorTypeDTO): GeneratorType {
        return when (source) {
            GeneratorTypeDTO.WORD_GENERATOR -> GeneratorType.WORD_GENERATOR
            GeneratorTypeDTO.PASSWORD_GENERATOR -> GeneratorType.PASSWORD_GENERATOR
            GeneratorTypeDTO.IP_GENERATOR -> GeneratorType.IP_GENERATOR
            GeneratorTypeDTO.REGEXP_GENERATOR -> GeneratorType.REGEXP_GENERATOR
        }
    }
}