package org.bomber.converter.model.script

import org.springframework.core.convert.converter.Converter
import org.bomber.model.script.RestConfiguration
import org.bomber.api.dto.script.RestConfigurationDTO

object RestConfigurationConverter : Converter<RestConfigurationDTO, RestConfiguration> {
    override fun convert(source: RestConfigurationDTO): RestConfiguration {
        return RestConfiguration(
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
