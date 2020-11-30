package org.bomber.repository.bombers

import org.bomber.model.device.Bomber

interface BomberRepository {
    suspend fun save(bomber: Bomber): Bomber

    suspend fun getAll(take: Int): List<Bomber>
}