package org.bomber.converter.dto.result

import org.springframework.core.convert.converter.Converter
import org.bomber.api.dto.result.ResponseDto
import org.bomber.model.result.Response

object ResponseDtoConverter : Converter<Response, ResponseDto> {
    override fun convert(source: Response): ResponseDto {
        return ResponseDto(
            code = source.code,
            time = source.time
        )
    }
}
