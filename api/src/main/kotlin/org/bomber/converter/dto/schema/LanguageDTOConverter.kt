package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.LanguageDTO
import org.bomber.model.schema.Language
import org.springframework.core.convert.converter.Converter

object LanguageDTOConverter : Converter<Language, LanguageDTO> {
    override fun convert(source: Language): LanguageDTO {
        return when (source) {
            Language.RU -> LanguageDTO.RU
            Language.EN -> LanguageDTO.EN
        }
    }
}