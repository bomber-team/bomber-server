package bomber.converter.model.schema

import bomber.dto.schema.BodyParamDTO
import bomber.dto.schema.ListPropertyDTO
import bomber.dto.schema.ObjectPropertyDTO
import bomber.dto.schema.SimplePropertyDTO
import bomber.model.schema.BodyParam
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