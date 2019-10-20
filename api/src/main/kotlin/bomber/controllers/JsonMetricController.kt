package bomber.controllers

import bomber.dto.CreateMetricRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Controller for collect metrics
 */
@RestController
@RequestMapping(
    value = ["/bomber/metrics/v1/metric"]
)
class JsonMetricController {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun createMetric(
        @RequestBody @Valid createMetricRequest: CreateMetricRequest
    ) = GlobalScope.launch {
        TODO("not implemented")
    }
}