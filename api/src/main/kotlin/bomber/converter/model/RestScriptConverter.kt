package bomber.converter.model

import bomber.dto.script.RestScriptDTO
import bomber.model.script.RestScript
import org.springframework.core.convert.converter.Converter

object RestScriptConverter: Converter<RestScriptDTO, RestScript> {
    override fun convert(source: RestScriptDTO): RestScript {
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