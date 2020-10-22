package org.bomber.model.result

data class Result(
    val bomberIp: String,
    val formId: String,
    val responses: List<Response>
)