package org.bomber.repository.rest.result

import kotlinx.coroutines.reactive.awaitFirst
import org.bomber.model.result.Result
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Component

@Component
class ResultRepositoryImpl(
    private val template: ReactiveMongoTemplate
) : ResultRepository {
    override suspend fun save(result: Result): Result {
        return template.save(result).awaitFirst()
    }
}