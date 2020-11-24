package org.bomber.api.dto.result

data class ResultDto(
    val bomberIp: String,
    val formId: String,
    val responses: List<ResponseDto>
)