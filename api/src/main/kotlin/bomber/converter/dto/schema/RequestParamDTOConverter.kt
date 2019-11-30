package bomber.converter.dto.schema

import bomber.dto.schema.RequestParamDTO
import bomber.model.schema.RequestParam
import org.springframework.core.convert.converter.Converter

object RequestParamDTOConverter : Converter<RequestParam, RequestParamDTO> {
    override fun convert(source: RequestParam): RequestParamDTO {
        return RequestParamDTO(
            name = source.name,
            isGeneratorNeed = source.isGeneratorNeed,
            value = source.value,
            generator = source.generator,
            config = source.config?.let { GeneratorConfigDTOConverter.convert(it) }
        )
    }
}