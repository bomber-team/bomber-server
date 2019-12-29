package org.bomber.api.dto.requests

data class CreateMetricRequest(
    val name: String,
    val value: Double
)