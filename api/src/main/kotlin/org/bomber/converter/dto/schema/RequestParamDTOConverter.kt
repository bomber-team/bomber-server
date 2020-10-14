package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.RequestParamDto
import org.bomber.model.schema.RequestParam
import org.springframework.core.convert.converter.Converter

object RequestParamDTOConverter : Converter<RequestParam, RequestParamDto> {
    override fun convert(source: RequestParam): RequestParamDto {
        return RequestParamDto(
            name = source.name,
            isGeneratorNeed = source.isGeneratorNeed,
            value = source.value,
            generator = source.generator,
            config = source.config?.let { GeneratorConfigDTOConverter.convert(it) }
        )
    }
}