package bomber.converter.dto.schema

import bomber.dto.schema.BodyParamTypeDTO
import bomber.model.schema.BodyParamType
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