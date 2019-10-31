package bomber.controllers

import bomber.dto.requests.CreateRequest
import bomber.dto.requests.UpdateRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import kotlin.coroutines.coroutineContext

@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/forms"]
)
class TestFormController {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun createForm(
        @RequestBody @Valid request: CreateRequest
    ) = GlobalScope.launch {
    }

    @PatchMapping("/{formId}", consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun updateForm(
        @PathVariable formId: String,
        @RequestBody @Valid request: UpdateRequest
    ) = GlobalScope.launch {
        TODO("Not implemented")
    }
}