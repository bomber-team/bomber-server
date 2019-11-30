package bomber.converter.dto.schema

import bomber.dto.schema.IpSectionDTO
import bomber.model.schema.IpSection
import org.springframework.core.convert.converter.Converter

object IpSectionDTOConverter : Converter<IpSection, IpSectionDTO> {
    override fun convert(source: IpSection): IpSectionDTO {
        return IpSectionDTO(
            min = source.min,
            max = source.max
        )
    }
}