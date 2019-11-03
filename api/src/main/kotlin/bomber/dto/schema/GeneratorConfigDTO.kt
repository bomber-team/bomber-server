package bomber.dto.schema

sealed class GeneratorConfigDTO

data class WordGeneratorConfigDTO(
    val minLetters: Int,
    val maxLetters: Int,
    val alphabet: String
) : GeneratorConfigDTO()

data class IpGeneratorConfig(
    val firstSection: IpSectionDTO,
    val secondSection: IpSectionDTO,
    val thirdSection: IpSectionDTO,
    val fourthSection: IpSectionDTO
) : GeneratorConfigDTO()

data class PasswordGeneratorConfig(
    val minLetters: Int,
    val maxLetters: Int,
    val language: LanguageDTO
) : GeneratorConfigDTO()

data class RegexpConfig(
    val pattern: String
) : GeneratorConfigDTO()