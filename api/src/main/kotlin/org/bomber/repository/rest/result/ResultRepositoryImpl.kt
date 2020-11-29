package org.bomber.repository.rest.result

import kotlinx.coroutines.reactive.awaitFirst
import org.bomber.model.result.Result
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Component

@Component
class ResultRepositoryImpl(
    private val template: ReactiveMongoTemplate
) : ResultRepository {
    override suspend fun save(result: Result): Result {
        return template.save(result).awaitFirst()
    }

    override suspend fun getAll(filter: ResultFilter): List<Result> {
        val criteria = Criteria.where(Result::formId.name).isEqualTo(filter.formId)
        val query = Query().addCriteria(criteria)

        return template.find(query, Result::class.java).collectList().awaitFirst()
    }
}