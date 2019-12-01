package bomber.converter.model.schema

import bomber.dto.schema.LanguageDTO
import bomber.model.schema.Language
import org.springframework.core.convert.converter.Converter

object LanguageConverter : Converter<LanguageDTO, Language> {
    override fun convert(source: LanguageDTO): Language {
        return when (source) {
            LanguageDTO.RU -> Language.RU
            LanguageDTO.EN -> Language.EN
        }
    }
}