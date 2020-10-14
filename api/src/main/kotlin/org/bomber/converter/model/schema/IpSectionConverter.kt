package org.bomber.converter.model.schema

import org.bomber.api.dto.schema.IpSectionDto
import org.bomber.model.schema.IpSection
import org.springframework.core.convert.converter.Converter

object IpSectionConverter : Converter<IpSectionDto, IpSection> {
    override fun convert(source: IpSectionDto): IpSection {
        return IpSection(
            min = source.min,
            max = source.max
        )
    }
}