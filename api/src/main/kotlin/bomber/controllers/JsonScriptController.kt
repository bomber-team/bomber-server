package bomber.controllers

import bomber.arango.ArangoDao.JsonScriptDao
import org.springframework.web.bind.annotation.*

/**
 * Controller for json scripts
 * describing the  restful test
 */
@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/scenario"]
)
class JsonScriptController {
    @GetMapping(value = ["/{id}"])
    fun getScript(@RequestParam id: String): String? {
        TODO()
    }

    @GetMapping
    fun getScriptAll(@RequestParam("offset") offset: Int, limit: Int): String? {
        TODO()
    }

    @PostMapping
    fun createScript(@RequestBody json: String): String {
        TODO()
    }

    @PutMapping
    fun updateScript(@RequestBody json: String): String {
        TODO()
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteScript(@RequestParam id: String): String {
        TODO()
    }
}