package bomber.converter.model.schema

import bomber.dto.schema.BodyParamTypeDTO
import bomber.model.schema.BodyParamType
import org.springframework.core.convert.converter.Converter

object BodyParamTypeConverter : Converter<BodyParamTypeDTO, BodyParamType> {
    override fun convert(source: BodyParamTypeDTO): BodyParamType {
        return when (source) {
            BodyParamTypeDTO.SIMPLE_PROPERTY -> BodyParamType.SIMPLE_PROPERTY
            BodyParamTypeDTO.LIST -> BodyParamType.LIST
            BodyParamTypeDTO.OBJECT -> BodyParamType.OBJECT
        }
    }
}