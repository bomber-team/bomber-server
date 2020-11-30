package org.bomber.model.device

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("bombers")
data class Bomber(
    @field:Id
    val id: UUID,
    val ip: String
)