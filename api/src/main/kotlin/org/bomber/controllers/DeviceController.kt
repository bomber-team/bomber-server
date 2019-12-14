package org.bomber.controllers

import org.bomber.dto.device.DeviceDTO
import org.bomber.dto.requests.CreateDeviceRequest
import org.bomber.dto.requests.UpdateDeviceRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Controller for manage devices
 */
@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/devices"]
)
class DeviceController {

    @PostMapping
    suspend fun createDevice(
        @RequestBody createDeviceRequest: CreateDeviceRequest
    ): ResponseEntity<DeviceDTO> {

    }

    @PatchMapping("/{id}")
    suspend fun updateDevice(
        @PathVariable id: String,
        @RequestBody updateDeviceRequest: UpdateDeviceRequest
    ): ResponseEntity<DeviceDTO> {

    }

    @GetMapping("/{id}")
    suspend fun getDevice(@PathVariable id: String): ResponseEntity<DeviceDTO> {

    }

    @GetMapping
    suspend fun getDevices(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<DeviceDTO> {

    }

    @DeleteMapping("/{id}")
    suspend fun deleteDevice(@PathVariable id: String): ResponseEntity<DeviceDTO> {

    }
}