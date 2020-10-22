package org.bomber.repository.rest.result

import org.bomber.model.result.Result

interface ResultRepository {
    suspend fun save(result: Result): Result
}