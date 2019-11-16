package bomber.models.schema

sealed class GeneratorConfig

data class WordGeneratorConfig(
    val minLetters: Int,
    val maxLetters: Int,
    val alphabet: String
) : GeneratorConfig()

data class IpGeneratorConfig(
    val firstSection: IpSection,
    val secondSection: IpSection,
    val thirdSection: IpSection,
    val fourthSection: IpSection
) : GeneratorConfig()

data class PasswordGeneratorConfig(
    val minLetters: Int,
    val maxLetters: Int,
    val language: Language
) : GeneratorConfig()

data class RegexpConfig(
    val pattern: String
) : GeneratorConfig()