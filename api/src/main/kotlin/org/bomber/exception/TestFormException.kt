package org.bomber.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

sealed class TestFormException(
    status: HttpStatus = HttpStatus.BAD_REQUEST,
    message: String
) : ResponseStatusException(status, message) {
    override fun toString(): String {
        return "RestScriptApiException($message)"
    }
}

class TestFormUpdateException(id: String) : TestFormException(
    status = HttpStatus.CONFLICT,
    message = "Conflict while update formId=$id, maybe concurrent update?"
)

class TestFormNotFoundException(id: String) : TestFormException(
    status = HttpStatus.NOT_FOUND,
    message = "Test form with id=$id was not found"
)