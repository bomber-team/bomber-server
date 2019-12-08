package org.bomber.exception

sealed class RestSchemaException(message: String) : Exception(message)

class RestSchemaNotFoundException(id: String) :
    RestSchemaException("RestSchema with id $id was not found")