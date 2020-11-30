package org.bomber.service.result

import org.bomber.api.dto.result.ResultDto
import org.bomber.api.dto.result.ResultItemsDto
import org.bomber.converter.dto.result.ResultDtoConverter
import org.bomber.repository.rest.result.ResultFilter
import org.bomber.repository.rest.result.ResultRepository
import org.springframework.stereotype.Component

@Component
class ResultService(
    private val repository: ResultRepository
) {
    suspend fun save(result: ResultDto) {
        TODO()
//        val converted = ResultConverter.convert(result)
//        repository.save(converted)
    }

    suspend fun getAll(formId: String): ResultItemsDto {
        val filter = ResultFilter(
            formId = formId
        )

        return ResultItemsDto(
            items = repository.getAll(filter).map { ResultDtoConverter.convert(it) }
        )
    }
}