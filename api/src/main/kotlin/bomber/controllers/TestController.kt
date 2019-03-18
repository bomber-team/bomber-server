package bomber.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @RequestMapping("/test")
    fun getTest(): String {
        return "application run successful"
    }
}