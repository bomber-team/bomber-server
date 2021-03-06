package org.bomber.controllers

import io.swagger.v3.oas.annotations.Operation
import org.bomber.api.dto.device.DeviceDTO
import org.bomber.api.dto.device.DeviceItemsDTO
import org.bomber.api.dto.requests.CreateDeviceRequest
import org.bomber.api.dto.requests.UpdateDeviceRequest
import org.bomber.service.device.DeviceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Controller for manage devices
 * @author Konstantin Volivach
 */
@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/devices"]
)
class DeviceController(
    private val deviceService: DeviceService
) {
    @PostMapping
    @Operation(hidden = true)
    suspend fun createDevice(
        @RequestBody createDeviceRequest: CreateDeviceRequest
    ): ResponseEntity<DeviceDTO> {
        val device = deviceService.createDevice(createDeviceRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(device)
    }

    @PatchMapping("/{id}")
    @Operation(hidden = true)
    suspend fun updateDevice(
        @PathVariable id: String,
        @RequestBody updateDeviceRequest: UpdateDeviceRequest
    ): ResponseEntity<DeviceDTO> {
        val device = deviceService.updateDevice(id, updateDeviceRequest)
        return ResponseEntity.ok(device)
    }

    @GetMapping("/{id}")
    @Operation(hidden = true)
    suspend fun getDevice(@PathVariable id: String): ResponseEntity<DeviceDTO> {
        val device = deviceService.getDevice(id)
        return ResponseEntity.ok(device)
    }

    @GetMapping
    @Operation(hidden = true)
    suspend fun getDevices(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<DeviceItemsDTO> {
        val devices = deviceService.getDevices(offset, limit)
        return ResponseEntity.ok(devices)
    }

    @DeleteMapping("/{id}")
    @Operation(hidden = true)
    suspend fun deleteDevice(@PathVariable id: String): ResponseEntity<DeviceDTO> {
        val device = deviceService.deleteDevice(id)
        return ResponseEntity.ok(device)
    }
}