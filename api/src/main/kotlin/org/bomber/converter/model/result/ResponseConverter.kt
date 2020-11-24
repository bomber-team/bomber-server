package org.bomber.converter.model.result

import org.springframework.core.convert.converter.Converter
import org.bomber.model.result.Response
import org.bomber.api.dto.result.ResponseDto

object ResponseConverter : Converter<ResponseDto, Response> {
    override fun convert(source: ResponseDto): Response {
        return Response(
            code = source.code,
            time = source.time
        )
    }
}
