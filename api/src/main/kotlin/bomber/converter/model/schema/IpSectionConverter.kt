package bomber.converter.model.schema

import bomber.dto.schema.IpSectionDTO
import bomber.model.schema.IpSection
import org.springframework.core.convert.converter.Converter

object IpSectionConverter : Converter<IpSectionDTO, IpSection> {
    override fun convert(source: IpSectionDTO): IpSection {
        return IpSection(
            min = source.min,
            max = source.max
        )
    }
}