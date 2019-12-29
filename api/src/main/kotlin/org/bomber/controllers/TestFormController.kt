package org.bomber.controllers

import org.bomber.api.dto.requests.CreateRequest
import org.bomber.api.dto.requests.UpdateRequest
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