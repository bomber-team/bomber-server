package bomber.converter.dto.schema

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