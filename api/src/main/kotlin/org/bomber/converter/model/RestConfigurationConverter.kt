package org.bomber.converter.model

import org.bomber.api.dto.script.RestConfigurationDto
import org.bomber.model.script.RestConfiguration
import org.springframework.core.convert.converter.Converter

object RestConfigurationConverter : Converter<RestConfigurationDto, RestConfiguration> {
    override fun convert(source: RestConfigurationDto): RestConfiguration {
        return RestConfiguration(
            requestAmount = source.requestAmount,
            rps = source.rps
        )
    }
}