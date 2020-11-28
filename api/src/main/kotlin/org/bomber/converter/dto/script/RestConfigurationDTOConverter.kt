package org.bomber.converter.dto.script

import org.bomber.api.dto.script.RestConfigurationDto
import org.bomber.model.script.RestConfiguration
import org.springframework.core.convert.converter.Converter

object RestConfigurationDTOConverter : Converter<RestConfiguration, RestConfigurationDto> {
    override fun convert(source: RestConfiguration): RestConfigurationDto {
        return RestConfigurationDto(
            rps = source.rps,
            time = source.time
        )
    }
}