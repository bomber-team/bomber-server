package org.bomber.exception

sealed class RestScriptException(message: String) : Exception(message)

class RestScriptNotFoundException(id: String) : RestScriptException(
    "Script with id $id was not found"
)