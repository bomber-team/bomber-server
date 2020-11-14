package org.bomber.repository.form

import org.bomber.model.form.TestFormStatus

data class FormUpdate(
    val name: String? = null,
    val scriptId: String? = null,
    val schemaId: String? = null,
    val status: TestFormStatus? = null
)