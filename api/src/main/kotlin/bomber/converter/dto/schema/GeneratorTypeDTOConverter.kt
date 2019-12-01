package bomber.converter.dto.schema

import bomber.dto.schema.GeneratorTypeDTO
import bomber.model.schema.GeneratorType
import org.springframework.core.convert.converter.Converter

object GeneratorTypeDTOConverter : Converter<GeneratorType, GeneratorTypeDTO> {
    override fun convert(source: GeneratorType): GeneratorTypeDTO {
        return when (source) {
            GeneratorType.WORD_GENERATOR -> GeneratorTypeDTO.WORD_GENERATOR
            GeneratorType.PASSWORD_GENERATOR -> GeneratorTypeDTO.PASSWORD_GENERATOR
            GeneratorType.IP_GENERATOR -> GeneratorTypeDTO.IP_GENERATOR
            GeneratorType.REGEXP_GENERATOR -> GeneratorTypeDTO.REGEXP_GENERATOR
        }
    }
}