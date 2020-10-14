package org.bomber.controllers

import org.bomber.api.dto.requests.CreateRestSchemaRequest
import org.bomber.api.dto.requests.UpdateRestSchemaRequest
import org.bomber.api.dto.schema.RestSchemaDTO
import org.bomber.api.dto.schema.RestSchemaItemsDto
import org.bomber.service.rest.schema.RestSchemaService
import org.springframework.http.HttpStatus
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
        val result = restSchemaService.create(request)
        return ResponseEntity.ok(result)
    }

    @PutMapping("/{id}")
    suspend fun updateSchema(
        @PathVariable id: String,
        @RequestBody request: UpdateRestSchemaRequest
    ): ResponseEntity<RestSchemaDTO> {
        val result = restSchemaService.update(id, request)
        return ResponseEntity.ok(result)
    }

    @GetMapping(value = ["/{id}"])
    suspend fun getSchema(@PathVariable id: String): ResponseEntity<RestSchemaDTO> {
        val result = restSchemaService.get(id)
        return ResponseEntity.ok(result)
    }

    @GetMapping
    suspend fun getList(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<RestSchemaItemsDto> {
        val result = restSchemaService.getAll(offset, limit)
        return ResponseEntity.ok(result)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun deleteSchema(@PathVariable id: String): ResponseEntity<Unit> {
        restSchemaService.delete(id)
        return ResponseEntity.noContent().build()
    }
}