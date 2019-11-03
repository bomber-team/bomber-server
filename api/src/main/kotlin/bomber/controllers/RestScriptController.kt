package bomber.controllers

import bomber.dto.requests.CreateScriptRequest
import bomber.dto.script.RestScriptDTO
import bomber.dto.script.RestScriptItemsDTO
import bomber.service.rest.script.ScriptService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author Konstantin Volivach
 */
@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/script/v1"]
)
class RestScriptController(
    private val scriptService: ScriptService
) {
    @PostMapping
    suspend fun createScript(@RequestBody request: CreateScriptRequest): ResponseEntity<RestScriptDTO> {
        val script = scriptService.createScript(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(script)
    }

    @PutMapping
    suspend fun updateScript(@RequestBody updateRequest: RestScriptDTO): ResponseEntity<RestScriptDTO> {
        val script = scriptService.updateScript(updateRequest)
        return ResponseEntity.status(HttpStatus.OK).body(script)
    }

    @GetMapping(value = ["/{id}"])
    suspend fun getScript(@RequestParam id: String): ResponseEntity<RestScriptDTO> {
        val script = scriptService.getScript(id)
        return ResponseEntity.status(HttpStatus.OK).body(script)
    }

    @GetMapping
    suspend fun getScriptAll(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<RestScriptItemsDTO> {
        val scriptItems = scriptService.getScriptAll(offset, limit)
        return ResponseEntity.status(HttpStatus.OK).body(scriptItems)
    }

    @DeleteMapping(value = ["/{id}"])
    suspend fun deleteScript(@RequestParam id: String): ResponseEntity<RestScriptDTO> {
        val deleted = scriptService.deleteScript(id)
        return ResponseEntity.status(HttpStatus.OK).body(deleted)
    }
}