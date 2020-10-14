package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.GeneratorConfigDto
import org.bomber.api.dto.schema.IpGeneratorConfigDto
import org.bomber.api.dto.schema.PasswordGeneratorConfigDto
import org.bomber.api.dto.schema.RegexpConfigDto
import org.bomber.api.dto.schema.WordGeneratorConfigDto
import org.bomber.model.schema.GeneratorConfig
import org.bomber.model.schema.IpGeneratorConfig
import org.bomber.model.schema.PasswordGeneratorConfig
import org.bomber.model.schema.RegexpConfig
import org.bomber.model.schema.WordGeneratorConfig
import org.springframework.core.convert.converter.Converter

object GeneratorConfigDTOConverter : Converter<GeneratorConfig, GeneratorConfigDto> {
    override fun convert(source: GeneratorConfig): GeneratorConfigDto {
        return when (source) {
            is WordGeneratorConfig -> WordGeneratorConfigDto(
                minLetters = source.minLetters,
                maxLetters = source.maxLetters,
                alphabet = source.alphabet
            )
            is IpGeneratorConfig -> IpGeneratorConfigDto(
                firstSection = IpSectionDTOConverter.convert(source.firstSection),
                secondSection = IpSectionDTOConverter.convert(source.secondSection),
                thirdSection = IpSectionDTOConverter.convert(source.thirdSection),
                fourthSection = IpSectionDTOConverter.convert(source.fourthSection)
            )
            is PasswordGeneratorConfig -> PasswordGeneratorConfigDto(
                minLetters = source.minLetters,
                maxLetters = source.maxLetters,
                language = LanguageDTOConverter.convert(source.language)
            )
            is RegexpConfig -> RegexpConfigDto(
                pattern = source.pattern
            )
        }
    }
}