package org.bomber.dto.requests

import org.bomber.dto.StatusFormDTO

class CreateRequest

data class UpdateRequest(
    val status: StatusFormDTO
)