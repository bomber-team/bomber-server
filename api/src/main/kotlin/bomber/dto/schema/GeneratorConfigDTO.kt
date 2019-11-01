package bomber.dto.schema

//TODO разный конфиг под каждый генератор
sealed class GeneratorConfigDTO

data class WordGeneratorConfigDTO(
    val minLetters: Int,
    val maxLetters: Int,
    val alphabet: String
) : GeneratorConfigDTO()