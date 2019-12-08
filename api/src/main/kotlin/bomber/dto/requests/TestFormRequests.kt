package bomber.dto.requests

import bomber.dto.StatusFormDTO

class CreateRequest

data class UpdateRequest(
    val status: StatusFormDTO
)