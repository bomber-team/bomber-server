package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.IpSectionDto
import org.bomber.model.schema.IpSection
import org.springframework.core.convert.converter.Converter

object IpSectionDTOConverter : Converter<IpSection, IpSectionDto> {
    override fun convert(source: IpSection): IpSectionDto {
        return IpSectionDto(
            min = source.min,
            max = source.max
        )
    }
}