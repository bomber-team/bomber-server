package bomber.converter.model

import bomber.dto.script.RestConfigurationDTO
import bomber.model.script.RestConfiguration
import org.springframework.core.convert.converter.Converter

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