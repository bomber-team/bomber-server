package bomber.converter.dto.script

import bomber.dto.script.RestConfigurationDTO
import bomber.model.script.RestConfiguration
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