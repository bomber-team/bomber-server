package org.bomber.repository.form

import org.bomber.model.form.TestForm

interface TestFormRepository {

    suspend fun save(form: TestForm): TestForm

    suspend fun update(id: String, update: FormUpdate): TestForm?

    suspend fun get(id: String): TestForm?

    suspend fun delete()
}