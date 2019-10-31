package bomber.controllers

import bomber.dto.schema.RestSchemaDTO
import bomber.dto.schema.RestSchemaItemsDTO
import bomber.service.rest.schema.RestSchemaService
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
    @PostMapping("/{id1}")
    suspend fun createSchema(@RequestBody json: String): ResponseEntity<RestSchemaDTO> {
        TODO()
    }

    @PutMapping("/{id}")
    suspend fun updateSchema(@RequestBody json: String): ResponseEntity<RestSchemaDTO> {
        TODO("")
    }

    @GetMapping(value = ["/{id}"])
    suspend fun getSchema(@PathVariable id: String): ResponseEntity<RestSchemaDTO> {
        TODO("")
    }

    @GetMapping
    suspend fun getSchemes(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<RestSchemaItemsDTO> {
        TODO()
    }

    @DeleteMapping(value = ["/{id}"])
    suspend fun deleteSchema(@PathVariable id: String): ResponseEntity<RestSchemaDTO> {
        TODO()
    }
}