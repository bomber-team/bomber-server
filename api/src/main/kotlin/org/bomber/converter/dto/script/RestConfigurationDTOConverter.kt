package org.bomber.converter.dto.script

import org.bomber.api.dto.script.RestConfigurationDTO
import org.bomber.model.script.RestConfiguration
import org.springframework.core.convert.converter.Converter

object RestConfigurationDTOConverter : Converter<RestConfiguration, RestConfigurationDTO> {
    override fun convert(source: RestConfiguration): RestConfigurationDTO {
        return RestConfigurationDTO(
            amountRequest = source.amountRequest,
            timeoutForOneRequest = source.timeoutForOneRequest,
            timeBetweenAttacks = source.timeBetweenAttacks,
            notifyAfterComplete = source.notifyAfterComplete,
            sendMetrics = source.sendMetrics,
            logging = source.logging,
            useGeneratedCache = source.useGeneratedCache
        )
    }
}