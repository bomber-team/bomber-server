package org.bomber.repository.rest.script

import org.bomber.model.script.RestScript

interface RestScriptRepository {
    suspend fun save(restScript: RestScript): RestScript

    suspend fun update(id: String, update: UpdateScript): RestScript?

    suspend fun get(id: String): RestScript?

    suspend fun getAll(): List<RestScript>

    suspend fun delete(id: String): Long?
}