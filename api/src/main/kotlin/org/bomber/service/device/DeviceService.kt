package org.bomber.service.device

import org.bomber.api.dto.device.DeviceDTO
import org.bomber.api.dto.device.DeviceItemsDTO
import org.bomber.api.dto.requests.CreateDeviceRequest
import org.bomber.api.dto.requests.UpdateDeviceRequest

interface DeviceService {
    suspend fun createDevice(createDeviceRequest: CreateDeviceRequest): DeviceDTO

    suspend fun updateDevice(id: String, updateDeviceRequest: UpdateDeviceRequest): DeviceDTO

    suspend fun getDevice(id: String): DeviceDTO

    suspend fun getDevices(offset: Int, limit: Int): DeviceItemsDTO

    suspend fun deleteDevice(id: String): DeviceDTO
}