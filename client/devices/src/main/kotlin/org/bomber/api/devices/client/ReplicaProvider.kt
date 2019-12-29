package org.bomber.api.devices.client

import java.net.URI

interface ReplicaProvider {
    fun getUris(): List<URI>
}