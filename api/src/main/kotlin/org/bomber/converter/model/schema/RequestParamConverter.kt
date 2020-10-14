package org.bomber.converter.model.schema

import org.bomber.api.dto.schema.RequestParamDto
import org.bomber.model.schema.RequestParam
import org.springframework.core.convert.converter.Converter

object RequestParamConverter : Converter<RequestParamDto, RequestParam> {
    override fun convert(source: RequestParamDto): RequestParam {
        return RequestParam(
            name = source.name,
            isGeneratorNeed = source.isGeneratorNeed,
            value = source.value,
            generator = source.generator,
            config = source.config?.let { GeneratorConfigConverter.convert(it) }
        )
    }
}