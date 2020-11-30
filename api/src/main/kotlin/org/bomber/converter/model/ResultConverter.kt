package org.bomber.converter.model

import org.bomber.team.contracts.Result
import org.bson.types.ObjectId
import org.springframework.core.convert.converter.Converter

object ResultConverter : Converter<Result.BomberResult, org.bomber.model.result.Result> {
    override fun convert(source: Result.BomberResult): org.bomber.model.result.Result {
        return org.bomber.model.result.Result(
            id = ObjectId().toHexString(),
            bomberIp = source.bomberIp,
            formId = source.formId,
            amountTimeoutsRequests = source.amountTimeoutsRequests,
            amountPerStatus = source.amountStatusesPerStatusMap,
            msPerRequest = source.msPerRequestList
        )
    }

}