package bomber.converter.model.schema

import bomber.dto.schema.GeneratorConfigDTO
import bomber.dto.schema.IpGeneratorConfigDTO
import bomber.dto.schema.PasswordGeneratorConfigDTO
import bomber.dto.schema.RegexpConfigDTO
import bomber.dto.schema.WordGeneratorConfigDTO
import bomber.model.schema.GeneratorConfig
import bomber.model.schema.IpGeneratorConfig
import bomber.model.schema.PasswordGeneratorConfig
import bomber.model.schema.RegexpConfig
import bomber.model.schema.WordGeneratorConfig
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