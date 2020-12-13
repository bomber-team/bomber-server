package org.bomber.converter.dto.result

import org.springframework.core.convert.converter.Converter
import org.bomber.api.dto.result.ResultDto
import org.bomber.model.result.Result

object ResultDtoConverter : Converter<Result, ResultDto> {
    override fun convert(source: Result): ResultDto {
        return ResultDto(
            id = source.id,
            bomberIp = source.bomberIp,
            formId = source.formId,
            sumTime = source.sumTime / NS_TO_S,
            amountTimeoutsRequests = source.amountTimeoutsRequests,
            amountPerStatus = source.amountPerStatus,
            msPerRequest = source.msPerRequest
        )
    }

    private const val NS_TO_S = 1_000_000 * 1_000
}
