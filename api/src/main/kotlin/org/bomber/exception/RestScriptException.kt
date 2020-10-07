package org.bomber.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

sealed class RestScriptException(
    status: HttpStatus = HttpStatus.BAD_REQUEST,
    message: String
) : ResponseStatusException(status, message) {
    override fun toString(): String {
        return "RestScriptApiException($message)"
    }
}

class RestScriptNotFoundException(id: String) : RestScriptException(
    status = HttpStatus.NOT_FOUND,
    message = "Script with id $id was not found"
)

class RestScriptUpdateException(id: String) : RestScriptException(
    status = HttpStatus.CONFLICT,
    message = "Script with id=$id was not updated, maybe concurrent modification was applyed"
)