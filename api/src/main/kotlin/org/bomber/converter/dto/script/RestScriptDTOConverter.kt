package org.bomber.converter.dto.script

import org.bomber.api.dto.script.RestScriptDto
import org.bomber.model.script.RestScript
import org.springframework.core.convert.converter.Converter

object RestScriptDTOConverter : Converter<RestScript, RestScriptDto> {
    override fun convert(source: RestScript): RestScriptDto {
        return RestScriptDto(
            id = source.id,
            name = source.name,
            address = source.address,
            requestMethod = source.requestMethod,
            configuration = RestConfigurationDTOConverter.convert(source.configuration)
        )
    }
}