package org.bomber.api.dto.result

data class ResultDto(
    val id: String,
    val bomberIp: String,
    val formId: String,
    val amountTimeoutsRequests: Long,
    val sumTime: Long,
    val amountPerStatus: Map<Int, Long>,
    val msPerRequest: List<Long>
)