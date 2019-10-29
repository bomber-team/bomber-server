package bomber.dto.schema

//TODO разный конфиг под каждый генератор
sealed class GeneratorConfigDTO

data class WordGeneratorConfigDTO(
    val minLetters: Long,
    val maxLetters: Long,
    val alphabet: String
) : GeneratorConfigDTO()