package org.bomber.converter.model

import org.bomber.model.result.Response
import org.bomber.team.contracts.Result
import org.springframework.core.convert.converter.Converter

object ResponseConverter : Converter<Result.Response, Response> {
    override fun convert(source: Result.Response): Response? {
        return Response(
            code = source.code,
            time = source.time
        )
    }
}