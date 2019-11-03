package bomber.dto.schema

sealed class GeneratorConfigDTO

data class WordGeneratorConfigDTO(
    val minLetters: Int,
    val maxLetters: Int,
    val alphabet: String
) : GeneratorConfigDTO()

data class IpGeneratorConfig(
    val firstSection: IpSection,
    val secondSection: IpSection,
    val thirdSection: IpSection,
    val fourthSection: IpSection
) : GeneratorConfigDTO()

data class PasswordGeneratorConfig(
    val minLetters: Int,
    val maxLetters: Int,
    val language: Language
) : GeneratorConfigDTO()

data class RegexpConfig(
    val pattern: String
) : GeneratorConfigDTO()