package org.bomber.converter.model.schema

import org.bomber.dto.schema.RequestParamDTO
import org.bomber.model.schema.RequestParam
import org.springframework.core.convert.converter.Converter

object RequestParamConverter : Converter<RequestParamDTO, RequestParam> {
    override fun convert(source: RequestParamDTO): RequestParam {
        return RequestParam(
            name = source.name,
            isGeneratorNeed = source.isGeneratorNeed,
            value = source.value,
            generator = source.generator,
            config = source.config?.let { GeneratorConfigConverter.convert(it) }
        )
    }
}