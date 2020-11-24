package org.bomber.service.result

import org.bomber.api.dto.result.ResultDto
import org.bomber.converter.model.result.ResultConverter
import org.bomber.repository.rest.result.ResultRepository
import org.springframework.stereotype.Component

@Component
class ResultService(
    private val repository: ResultRepository
) {
    suspend fun save(result: ResultDto) {
        val converted = ResultConverter.convert(result)
        repository.save(converted)
    }
}