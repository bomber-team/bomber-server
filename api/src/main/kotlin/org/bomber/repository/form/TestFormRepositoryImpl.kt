package org.bomber.repository.form

import org.bomber.model.form.TestForm
import org.springframework.stereotype.Component

@Component
class TestFormRepositoryImpl : TestFormRepository {
    override suspend fun save(form: TestForm): TestForm {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun update(id: String, update: FormUpdate): TestForm? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun delete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}