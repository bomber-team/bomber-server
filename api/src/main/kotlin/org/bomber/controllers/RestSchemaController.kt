package org.bomber.controllers

import org.bomber.dto.requests.CreateRestSchemaRequest
import org.bomber.dto.requests.UpdateRestSchemaRequest
import org.bomber.dto.schema.RestSchemaDTO
import org.bomber.dto.schema.RestSchemaItemsDTO
import org.bomber.service.rest.schema.RestSchemaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * controller for routes json scenarios
 * @author kostya05983
 */
@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/schema/v1"]
)
class RestSchemaController(
    private val restSchemaService: RestSchemaService
) {
    @PostMapping
    suspend fun createSchema(@RequestBody request: CreateRestSchemaRequest): ResponseEntity<RestSchemaDTO> {
        val result = restSchemaService.createSchema(request)
        return ResponseEntity.ok(result)
    }

    @PutMapping("/{id}")
    suspend fun updateSchema(
        @PathVariable id: String,
        @RequestBody request: UpdateRestSchemaRequest
    ): ResponseEntity<RestSchemaDTO> {
        val result = restSchemaService.updateSchema(id, request)
        return ResponseEntity.ok(result)
    }

    @GetMapping(value = ["/{id}"])
    suspend fun getSchema(@PathVariable id: String): ResponseEntity<RestSchemaDTO> {
        val result = restSchemaService.getSchema(id)
        return ResponseEntity.ok(result)
    }

    @GetMapping
    suspend fun getSchemes(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<RestSchemaItemsDTO> {
        val result = restSchemaService.getSchemes(offset, limit)
        return ResponseEntity.ok(result)
    }

    @DeleteMapping(value = ["/{id}"])
    suspend fun deleteSchema(@PathVariable id: String): ResponseEntity<RestSchemaDTO> {
        val result = restSchemaService.deleteSchema(id)
        return ResponseEntity.ok(result)
    }
}