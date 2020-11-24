package org.bomber.controllers

import org.bomber.api.dto.requests.CreateScriptRequest
import org.bomber.api.dto.requests.UpdateScriptRequest
import org.bomber.api.dto.script.RestScriptDto
import org.bomber.api.dto.script.RestScriptItemsDTO
import org.bomber.service.rest.script.RestScriptService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author Konstantin Volivach
 */
@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/scripts"]
)
class RestScriptController(
    private val scriptService: RestScriptService
) {
    @PostMapping
    suspend fun createScript(@RequestBody request: CreateScriptRequest): ResponseEntity<RestScriptDto> {
        val script = scriptService.create(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(script)
    }

    @PutMapping("/{id}")
    suspend fun updateScript(
        @PathVariable id: String,
        @RequestBody updateRequest: UpdateScriptRequest
    ): ResponseEntity<RestScriptDto> {
        val script = scriptService.update(id, updateRequest)
        return ResponseEntity.status(HttpStatus.OK).body(script)
    }

    @GetMapping(value = ["/{id}"])
    suspend fun getScript(@PathVariable id: String): ResponseEntity<RestScriptDto> {
        val script = scriptService.get(id)
        return ResponseEntity.status(HttpStatus.OK).body(script)
    }

    @GetMapping
    suspend fun getList(
        @RequestParam("skip") skip: Long,
        @RequestParam("take") take: Int
    ): ResponseEntity<RestScriptItemsDTO> {
        val scriptItems = scriptService.getAll(skip, take)
        return ResponseEntity.status(HttpStatus.OK).body(scriptItems)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun deleteScript(@PathVariable id: String): ResponseEntity<Unit> {
        scriptService.delete(id)
        return ResponseEntity.noContent().build()
    }
}