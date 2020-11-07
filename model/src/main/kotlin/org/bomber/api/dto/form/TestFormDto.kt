package org.bomber.api.dto.form

data class TestFormDto(
    val id: String,
    val name: String,
    val status: TestFormStatusDto,
    val schemaId: String,
    val scriptId: String
)