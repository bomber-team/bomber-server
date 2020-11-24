package org.bomber.controllers

import io.swagger.v3.oas.annotations.Operation
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.bomber.api.dto.result.ResultDto
import org.bomber.service.result.ResultService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/v1/results"]
)
class ResultsController(
    private val resultService: ResultService
) {

    @PostMapping
    @Operation(hidden = true)
    fun createResult(
        @RequestBody @Valid result: ResultDto
    ) = GlobalScope.launch {
        resultService.save(result)
    }
}