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
            responses = source.responses.map { ResponseDtoConverter.convert(it) }
        )
    }
}
