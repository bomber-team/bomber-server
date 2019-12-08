package org.bomber.converter.dto.script

import org.bomber.dto.script.RestScriptDTO
import org.bomber.model.script.RestScript
import org.springframework.core.convert.converter.Converter

object RestScriptDTOConverter : Converter<RestScript, RestScriptDTO> {
    override fun convert(source: RestScript): RestScriptDTO {
        return RestScriptDTO(
            id = source.id,
            schemeId = source.schemeId,
            name = source.name,
            address = source.address,
            requestMethod = source.requestMethod,
            configuration = RestConfigurationDTOConverter.convert(source.configuration)
        )
    }
}