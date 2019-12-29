package org.bomber.converter.model.schema

import org.bomber.api.dto.schema.IpSectionDTO
import org.bomber.model.schema.IpSection
import org.springframework.core.convert.converter.Converter

object IpSectionConverter : Converter<IpSectionDTO, IpSection> {
    override fun convert(source: IpSectionDTO): IpSection {
        return IpSection(
            min = source.min,
            max = source.max
        )
    }
}