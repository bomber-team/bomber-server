package bomber.converter.dto.schema

import bomber.dto.schema.BodyParamDTO
import bomber.model.schema.BodyParam
import bomber.model.schema.ListProperty
import bomber.model.schema.ObjectProperty
import bomber.model.schema.SimpleProperty
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