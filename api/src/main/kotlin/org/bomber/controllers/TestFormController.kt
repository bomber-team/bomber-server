package org.bomber.controllers

import org.bomber.api.dto.requests.CreateTestFormRequest
import org.bomber.api.dto.requests.UpdateTestFormRequest
import org.bomber.service.coroutines.coroutineToMono
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/forms"]
)
class TestFormController {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createForm(
        @RequestBody @Valid request: CreateTestFormRequest
    ) = coroutineToMono {
    }

    @PatchMapping("/{formId}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateForm(
        @PathVariable formId: String,
        @RequestBody @Valid request: UpdateTestFormRequest
    ) = coroutineToMono {
        TODO("Not implemented")
    }

    @PostMapping("/{formId}/run")
    fun runForm(
        @PathVariable formId: String
    ) = coroutineToMono {
        TODO("Not implemented")
    }
}