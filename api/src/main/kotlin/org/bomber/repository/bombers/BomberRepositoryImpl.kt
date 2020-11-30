package org.bomber.repository.bombers

import kotlinx.coroutines.reactive.awaitFirst
import org.bomber.model.device.Bomber
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class BomberRepositoryImpl(
    private val template: ReactiveMongoTemplate
) : BomberRepository {
    override suspend fun save(bomber: Bomber): Bomber {
        return template.save(bomber).awaitFirst()
    }

    override suspend fun getAll(take: Int): List<Bomber> {
        val query = Query().limit(take)

        return template.find(query, Bomber::class.java).collectList().awaitFirst()
    }
}