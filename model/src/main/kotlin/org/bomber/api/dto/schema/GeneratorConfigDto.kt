package org.bomber.api.dto.schema

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping
import io.swagger.v3.oas.annotations.media.Schema

@Schema(
    name = "GeneratorConfig",
    oneOf = [
        WordGeneratorConfigDto::class,
        IpGeneratorConfigDto::class,
        PasswordGeneratorConfigDto::class,
        RegexpConfigDto::class
    ],
    discriminatorProperty = "type",
    discriminatorMapping = [
        DiscriminatorMapping("WORD", schema = WordGeneratorConfigDto::class),
        DiscriminatorMapping("IP", schema = IpGeneratorConfigDto::class),
        DiscriminatorMapping("PASSWORD", schema = PasswordGeneratorConfigDto::class),
        DiscriminatorMapping("REGEXP", schema = RegexpConfigDto::class)
    ]
)
@JsonTypeInfo(property = "type", use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes(
    JsonSubTypes.Type(WordGeneratorConfigDto::class, name = "WORD"),
    JsonSubTypes.Type(IpGeneratorConfigDto::class, name = "IP"),
    JsonSubTypes.Type(PasswordGeneratorConfigDto::class, name = "PASSWORD"),
    JsonSubTypes.Type(RegexpConfigDto::class, name = "REGEXP")
)
sealed class GeneratorConfigDto(
    val type: GeneratorConfigTypeDto
)

data class WordGeneratorConfigDto(
    val minLetters: Int,
    val maxLetters: Int,
    val alphabet: String
) : GeneratorConfigDto(GeneratorConfigTypeDto.WORD)

data class IpGeneratorConfigDto(
    val firstSection: IpSectionDto,
    val secondSection: IpSectionDto,
    val thirdSection: IpSectionDto,
    val fourthSection: IpSectionDto
) : GeneratorConfigDto(GeneratorConfigTypeDto.IP)

data class PasswordGeneratorConfigDto(
    val minLetters: Int,
    val maxLetters: Int,
    val language: LanguageDto
) : GeneratorConfigDto(GeneratorConfigTypeDto.PASSWORD)

data class RegexpConfigDto(
    val pattern: String
) : GeneratorConfigDto(GeneratorConfigTypeDto.REGEXP)

enum class GeneratorConfigTypeDto {
    WORD,
    IP,
    PASSWORD,
    REGEXP
}