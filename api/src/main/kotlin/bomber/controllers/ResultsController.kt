package bomber.controllers

import bomber.dto.requests.CreateResultRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/results"]
)
class ResultsController {

    @PostMapping
    fun createResult(
        @RequestBody @Valid createRequest: CreateResultRequest
    ) = GlobalScope.launch {
    }
}