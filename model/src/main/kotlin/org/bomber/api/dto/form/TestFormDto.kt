package org.bomber.api.dto.form

data class TestFormDto(
    val id: String,
    val name: String,
    val status: StatusFormDto,
    val schemaId: String,
    val scriptId: String
)