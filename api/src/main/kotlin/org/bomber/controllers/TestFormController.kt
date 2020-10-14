package org.bomber.controllers

import org.bomber.api.dto.requests.CreateTestFormRequest
import org.bomber.api.dto.requests.UpdateTestFormRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/forms"]
)
class TestFormController {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun createForm(
        @RequestBody @Valid request: CreateTestFormRequest
    ) = GlobalScope.launch {
    }

    @PatchMapping("/{formId}", consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun updateForm(
        @PathVariable formId: String,
        @RequestBody @Valid request: UpdateTestFormRequest
    ) = GlobalScope.launch {
        TODO("Not implemented")
    }
}