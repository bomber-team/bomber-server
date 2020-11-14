package org.bomber.model.form

import org.springframework.data.annotation.Version

data class TestForm(
    val id: String,

    val name: String,

    val status: TestFormStatus,

    val schemaId: String,

    val scriptId: String,

    val event: FormDatabaseEvent?,

    @field:Version
    val version: Long?
)