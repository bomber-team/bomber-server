package org.bomber.service.device

import org.bomber.dto.device.DeviceDTO
import org.bomber.dto.device.DeviceItemsDTO
import org.bomber.dto.requests.CreateDeviceRequest
import org.bomber.dto.requests.UpdateDeviceRequest
import org.springframework.stereotype.Service

@Service
class DeviceServiceImpl : DeviceService {
    override suspend fun createDevice(createDeviceRequest: CreateDeviceRequest): DeviceDTO {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun updateDevice(id: String, updateDeviceRequest: UpdateDeviceRequest): DeviceDTO {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getDevice(id: String): DeviceDTO {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getDevices(offset: Int, limit: Int): DeviceItemsDTO {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteDevice(id: String): DeviceDTO {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}