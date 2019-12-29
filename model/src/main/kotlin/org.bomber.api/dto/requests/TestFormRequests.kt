package org.bomber.api.dto.requests

import org.bomber.api.dto.StatusFormDTO

class CreateRequest

data class UpdateRequest(
    val status: StatusFormDTO
)