package org.bomber.converter.model.schema

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

object GeneratorConfigConverter : Converter<GeneratorConfigDto, GeneratorConfig> {
    override fun convert(source: GeneratorConfigDto): GeneratorConfig {
        return when (source) {
            is WordGeneratorConfigDto -> WordGeneratorConfig(
                minLetters = source.minLetters,
                maxLetters = source.maxLetters,
                alphabet = source.alphabet
            )
            is IpGeneratorConfigDto -> IpGeneratorConfig(
                firstSection = IpSectionConverter.convert(source.firstSection),
                secondSection = IpSectionConverter.convert(source.secondSection),
                thirdSection = IpSectionConverter.convert(source.thirdSection),
                fourthSection = IpSectionConverter.convert(source.fourthSection)
            )
            is PasswordGeneratorConfigDto -> PasswordGeneratorConfig(
                minLetters = source.minLetters,
                maxLetters = source.maxLetters,
                language = LanguageConverter.convert(source.language)
            )
            is RegexpConfigDto -> RegexpConfig(
                pattern = source.pattern
            )
        }
    }
}