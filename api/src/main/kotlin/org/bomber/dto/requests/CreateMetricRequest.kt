package org.bomber.dto.requests

data class CreateMetricRequest(
    val name: String,
    val value: Double
)