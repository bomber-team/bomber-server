package org.bomber.repository.rest.script

import org.bomber.model.script.RestScript

interface RestScriptRepository {
    suspend fun saveScript(restScript: RestScript): RestScript

    suspend fun getScript(id: String): RestScript?

    suspend fun getScripts(): List<RestScript>

    suspend fun deleteScript(id: String): RestScript?
}