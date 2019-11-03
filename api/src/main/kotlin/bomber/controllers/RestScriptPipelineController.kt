package bomber.controllers

import bomber.dto.script.RestScriptPipelineDTO
import bomber.dto.script.RestScriptPipelineItemsDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/script-pipeline/v1"]
)
class RestScriptPipelineController {
    @PostMapping
    suspend fun createScriptPipeline(@RequestBody json: String): ResponseEntity<RestScriptPipelineDTO> {
        TODO()
    }

    @PutMapping
    suspend fun updateScript(@RequestBody json: String): ResponseEntity<RestScriptPipelineDTO> {
        TODO()
    }

    @GetMapping(value = ["/{id}"])
    suspend fun getScript(@RequestParam id: String): ResponseEntity<RestScriptPipelineDTO> {
        TODO()
    }

    @GetMapping
    suspend fun getScriptAll(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<RestScriptPipelineItemsDTO> {
        TODO()
    }

    @DeleteMapping(value = ["/{id}"])
    suspend fun deleteScript(@RequestParam id: String): ResponseEntity<RestScriptPipelineDTO> {
        TODO()
    }
}