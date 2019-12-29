package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.GeneratorConfigDTO
import org.bomber.api.dto.schema.IpGeneratorConfigDTO
import org.bomber.api.dto.schema.PasswordGeneratorConfigDTO
import org.bomber.api.dto.schema.RegexpConfigDTO
import org.bomber.api.dto.schema.WordGeneratorConfigDTO
import org.bomber.model.schema.GeneratorConfig
import org.bomber.model.schema.IpGeneratorConfig
import org.bomber.model.schema.PasswordGeneratorConfig
import org.bomber.model.schema.RegexpConfig
import org.bomber.model.schema.WordGeneratorConfig
import org.springframework.core.convert.converter.Converter

object GeneratorConfigDTOConverter : Converter<GeneratorConfig, GeneratorConfigDTO> {
    override fun convert(source: GeneratorConfig): GeneratorConfigDTO {
        return when (source) {
            is WordGeneratorConfig -> WordGeneratorConfigDTO(
                minLetters = source.minLetters,
                maxLetters = source.maxLetters,
                alphabet = source.alphabet
            )
            is IpGeneratorConfig -> IpGeneratorConfigDTO(
                firstSection = IpSectionDTOConverter.convert(source.firstSection),
                secondSection = IpSectionDTOConverter.convert(source.secondSection),
                thirdSection = IpSectionDTOConverter.convert(source.thirdSection),
                fourthSection = IpSectionDTOConverter.convert(source.fourthSection)
            )
            is PasswordGeneratorConfig -> PasswordGeneratorConfigDTO(
                minLetters = source.minLetters,
                maxLetters = source.maxLetters,
                language = LanguageDTOConverter.convert(source.language)
            )
            is RegexpConfig -> RegexpConfigDTO(
                pattern = source.pattern
            )
        }
    }
}