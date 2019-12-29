package org.bomber.converter.model.schema

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

object GeneratorConfigConverter : Converter<GeneratorConfigDTO, GeneratorConfig> {
    override fun convert(source: GeneratorConfigDTO): GeneratorConfig {
        return when (source) {
            is WordGeneratorConfigDTO -> WordGeneratorConfig(
                minLetters = source.minLetters,
                maxLetters = source.maxLetters,
                alphabet = source.alphabet
            )
            is IpGeneratorConfigDTO -> IpGeneratorConfig(
                firstSection = IpSectionConverter.convert(source.firstSection),
                secondSection = IpSectionConverter.convert(source.secondSection),
                thirdSection = IpSectionConverter.convert(source.thirdSection),
                fourthSection = IpSectionConverter.convert(source.fourthSection)
            )
            is PasswordGeneratorConfigDTO -> PasswordGeneratorConfig(
                minLetters = source.minLetters,
                maxLetters = source.maxLetters,
                language = LanguageConverter.convert(source.language)
            )
            is RegexpConfigDTO -> RegexpConfig(
                pattern = source.pattern
            )
        }
    }
}