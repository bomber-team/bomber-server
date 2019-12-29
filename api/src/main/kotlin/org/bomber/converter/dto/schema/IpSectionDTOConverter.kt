package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.IpSectionDTO
import org.bomber.model.schema.IpSection
import org.springframework.core.convert.converter.Converter

object IpSectionDTOConverter : Converter<IpSection, IpSectionDTO> {
    override fun convert(source: IpSection): IpSectionDTO {
        return IpSectionDTO(
            min = source.min,
            max = source.max
        )
    }
}