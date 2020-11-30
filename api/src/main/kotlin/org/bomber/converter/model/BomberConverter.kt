package org.bomber.converter.model

import org.bomber.model.device.Bomber
import org.bomber.team.contracts.Init
import org.springframework.core.convert.converter.Converter
import java.util.*

object BomberConverter : Converter<Init.InitBomberPayload, Bomber> {
    override fun convert(source: Init.InitBomberPayload): Bomber {
        return Bomber(
            id = UUID.fromString(source.bomberId),
            ip = source.bomberIp
        )
    }
}