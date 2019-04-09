package bomber.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class JsonScenarioController {

    companion object {
        const val API = "/jsonScenario"
    }

    @RequestMapping(API, method = [RequestMethod.GET])
    fun getScenario(@RequestParam(name = "id") id: String) {

    }
}