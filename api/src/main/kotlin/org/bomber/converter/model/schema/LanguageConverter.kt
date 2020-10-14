package org.bomber.converter.model.schema

import org.bomber.api.dto.schema.LanguageDto
import org.bomber.model.schema.Language
import org.springframework.core.convert.converter.Converter

object LanguageConverter : Converter<LanguageDto, Language> {
    override fun convert(source: LanguageDto): Language {
        return when (source) {
            LanguageDto.RU -> Language.RU
            LanguageDto.EN -> Language.EN
        }
    }
}