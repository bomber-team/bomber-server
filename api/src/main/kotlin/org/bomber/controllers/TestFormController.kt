package org.bomber.controllers

import org.bomber.api.dto.requests.CreateTestFormRequest
import org.bomber.api.dto.requests.UpdateTestFormRequest
import org.bomber.service.coroutines.coroutineToMono
import org.bomber.service.form.TestFormService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/test-forms"]
)
class TestFormController(
    private val service: TestFormService
) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createForm(
        @RequestBody @Valid request: CreateTestFormRequest
    ) = coroutineToMono {
        service.create(request)
    }

    @PatchMapping("/{formId}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateForm(
        @PathVariable formId: String,
        @RequestBody @Valid request: UpdateTestFormRequest
    ) = coroutineToMono {
        val form = service.update(formId, request)
        ResponseEntity.ok(form)
    }

    @GetMapping
    fun getForms(
        @RequestParam("skip") skip: Long,
        @RequestParam("take") take: Int
    ) = coroutineToMono {
        val forms = service.getAll(take, skip)
        ResponseEntity.ok(forms)
    }

    @PostMapping("/{formId}/run")
    fun runForm(
        @PathVariable formId: String
    ) = coroutineToMono {
        val form = service.run(formId)
        ResponseEntity.ok(form)
    }

    @DeleteMapping("/{formId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteForm(
        @PathVariable formId: String
    ) = coroutineToMono {
        service.delete(formId)
    }
}