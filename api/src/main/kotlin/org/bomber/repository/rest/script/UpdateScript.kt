package org.bomber.repository.rest.script

import org.bomber.model.script.RestConfiguration

data class UpdateScript(
    val name: String?,
    val address: String?,
    val requestMethod: String?,
    val configuration: RestConfiguration?
)