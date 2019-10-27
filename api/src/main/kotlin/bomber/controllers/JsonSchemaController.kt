package bomber.controllers

import org.springframework.web.bind.annotation.*

/**
 * controller for routes json scenarios
 * @author kostya05983
 */
@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/schema"]
)
class JsonSchemaController {
    @GetMapping(value = ["/{id}"])
    fun getScenario(@PathVariable id: String): String? {
        TODO("")
    }

    @GetMapping
    fun getSchemes(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): String {
        TODO()
    }

    @PostMapping
    fun createScenario(@RequestBody json: String): String {
        TODO()
    }

    @PutMapping
    fun updateScenario(@RequestBody json: String): String {
        TODO("")
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteScenario(@PathVariable id: String): String {
        return "maybe delete heh"
    }
}