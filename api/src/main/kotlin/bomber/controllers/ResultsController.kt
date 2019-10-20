package bomber.controllers

import bomber.dto.CreateResultRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(
    value = ["/bomber/metrics/v1/results"]
)
class ResultsController {

    @PostMapping
    fun createResult(
        @RequestBody @Valid createRequest: CreateResultRequest
    ) = GlobalScope.launch {

    }
}