package org.bomber.dto.schema

sealed class GeneratorConfigDTO

data class WordGeneratorConfigDTO(
    val minLetters: Int,
    val maxLetters: Int,
    val alphabet: String
) : GeneratorConfigDTO()

data class IpGeneratorConfigDTO(
    val firstSection: IpSectionDTO,
    val secondSection: IpSectionDTO,
    val thirdSection: IpSectionDTO,
    val fourthSection: IpSectionDTO
) : GeneratorConfigDTO()

data class PasswordGeneratorConfigDTO(
    val minLetters: Int,
    val maxLetters: Int,
    val language: LanguageDTO
) : GeneratorConfigDTO()

data class RegexpConfigDTO(
    val pattern: String
) : GeneratorConfigDTO()