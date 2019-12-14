package org.bomber.service.device

import org.bomber.dto.device.DeviceDTO
import org.bomber.dto.device.DeviceItemsDTO
import org.bomber.dto.requests.CreateDeviceRequest
import org.bomber.dto.requests.UpdateDeviceRequest

interface DeviceService {
    suspend fun createDevice(createDeviceRequest: CreateDeviceRequest): DeviceDTO

    suspend fun updateDevice(id: String, updateDeviceRequest: UpdateDeviceRequest): DeviceDTO

    suspend fun getDevice(id: String): DeviceDTO

    suspend fun getDevices(offset: Int, limit: Int): DeviceItemsDTO

    suspend fun deleteDevice(id: String): DeviceDTO
}