package org.bomber.converter.model

import org.bomber.team.contracts.Result
import org.springframework.core.convert.converter.Converter

object ResultConverter : Converter<Result.BomberResult, org.bomber.model.result.Result> {
    override fun convert(source: Result.BomberResult): org.bomber.model.result.Result {
        return org.bomber.model.result.Result(
            bomberIp = source.bomberIp,
            formId = source.formId,
            responses = source.responsesList.map { ResponseConverter.convert(it) }
        )
    }

}