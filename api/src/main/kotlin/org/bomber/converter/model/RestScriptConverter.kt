package org.bomber.converter.model

import org.bomber.api.dto.script.RestScriptDto
import org.bomber.model.script.RestScript
import org.springframework.core.convert.converter.Converter

object RestScriptConverter : Converter<RestScriptDto, RestScript> {
    override fun convert(source: RestScriptDto): RestScript {
        return RestScript(
            id = source.id,
            schemeId = source.schemeId,
            name = source.name,
            address = source.address,
            requestMethod = source.requestMethod,
            configuration = RestConfigurationConverter.convert(source.configuration)
        )
    }
}