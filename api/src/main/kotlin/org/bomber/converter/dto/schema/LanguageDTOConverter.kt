package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.LanguageDto
import org.bomber.model.schema.Language
import org.springframework.core.convert.converter.Converter

object LanguageDTOConverter : Converter<Language, LanguageDto> {
    override fun convert(source: Language): LanguageDto {
        return when (source) {
            Language.RU -> LanguageDto.RU
            Language.EN -> LanguageDto.EN
        }
    }
}