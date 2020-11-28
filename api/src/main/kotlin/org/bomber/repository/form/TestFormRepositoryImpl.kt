package org.bomber.repository.form

import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.bomber.model.form.TestForm
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Component

@Component
class TestFormRepositoryImpl(
    private val template: ReactiveMongoTemplate
) : TestFormRepository {
    override suspend fun save(form: TestForm): TestForm {
        return template.save(form).awaitFirst()
    }

    override suspend fun update(id: String, update: FormUpdate): TestForm? {
        val criteria = Criteria.where(TestForm::id.name).isEqualTo(id)

        val query = Query().addCriteria(criteria)

        val mongoUpdate = Update().apply {
            update.name?.let {
                set(TestForm::name.name, it)
            }
            update.scriptId?.let {
                set(TestForm::scriptId.name, it)
            }
            update.schemaId?.let {
                set(TestForm::schemaId.name, it)
            }
            update.status?.let {
                set(TestForm::status.name, it)
            }
            update.event?.let {
                set(TestForm::event.name, it)
            }
        }

        val options = FindAndModifyOptions().returnNew(true)

        return template.findAndModify(query, mongoUpdate, options, TestForm::class.java).awaitFirstOrNull()
    }

    override suspend fun get(id: String): TestForm? {
        val criteria = Criteria.where(TestForm::id.name).isEqualTo(id)
        val query = Query().addCriteria(criteria)

        return template.find(query, TestForm::class.java).awaitFirstOrNull()
    }

    override suspend fun getAll(filter: FormsFilter): List<TestForm> {
        val query = Query().skip(filter.skip).limit(filter.take)

        return template.find(query, TestForm::class.java).collectList().awaitFirst()
    }

    override suspend fun delete(formId: String) {
        val criteria = Criteria.where(TestForm::id.name).isEqualTo(formId)
        val query = Query().addCriteria(criteria)

        template.remove(query, TestForm::class.java).awaitFirst()
    }
}