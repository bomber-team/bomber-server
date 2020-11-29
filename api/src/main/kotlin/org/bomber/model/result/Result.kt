package org.bomber.model.result

import org.springframework.data.annotation.Id

data class Result(
    @field:Id
    val id: String,
    val bomberIp: String,
    val formId: String,
    val responses: List<Response>
)