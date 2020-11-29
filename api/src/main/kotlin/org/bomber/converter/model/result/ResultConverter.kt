package org.bomber.converter.model.result

import org.springframework.core.convert.converter.Converter
import org.bomber.model.result.Result
import org.bomber.api.dto.result.ResultDto

object ResultConverter : Converter<ResultDto, Result> {
    override fun convert(source: ResultDto): Result {
        return Result(
            id = source.id,
            bomberIp = source.bomberIp,
            formId = source.formId,
            responses = source.responses.map { ResponseConverter.convert(it) }
        )
    }
}
