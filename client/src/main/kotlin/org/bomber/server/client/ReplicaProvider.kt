package org.bomber.server.client

import java.net.URI

interface ReplicaProvider {
    fun getUris(): List<URI>
}