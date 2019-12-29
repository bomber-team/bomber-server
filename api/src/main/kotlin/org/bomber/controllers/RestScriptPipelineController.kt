package org.bomber.controllers

import org.bomber.api.dto.requests.CreateScriptPipeline
import org.bomber.api.dto.requests.UpdateScriptPipeline
import org.bomber.model.script.RestScriptPipeline
import org.bomber.model.script.RestScriptPipelineItems
import org.bomber.service.rest.script.pipeline.RestScriptPipelineService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/script-pipeline/v1"]
)
class RestScriptPipelineController(
    private val restScriptPipelineService: RestScriptPipelineService
) {
    @PostMapping
    suspend fun createScriptPipeline(@RequestBody createRequest: CreateScriptPipeline): ResponseEntity<RestScriptPipeline> {
        val pipeline = restScriptPipelineService.createScriptPipeline(createRequest)
        return ResponseEntity.ok(pipeline)
    }

    @PutMapping("/{id}")
    suspend fun updateScriptPipeline(@PathVariable id: String, @RequestBody updateRequest: UpdateScriptPipeline): ResponseEntity<RestScriptPipeline> {
        val pipeline = restScriptPipelineService.updateScriptPipeline(id, updateRequest)
        return ResponseEntity.ok(pipeline)
    }

    @GetMapping(value = ["/{id}"])
    suspend fun getScriptPipeline(
        @PathVariable id: String
    ): ResponseEntity<RestScriptPipeline> {
        val pipeline = restScriptPipelineService.getScriptPipeline(id)
        return ResponseEntity.ok(pipeline)
    }

    @GetMapping
    suspend fun getScriptPipelines(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<RestScriptPipelineItems> {
        val pipelines = restScriptPipelineService.getScriptPipelines(offset, limit)
        return ResponseEntity.ok(pipelines)
    }

    @DeleteMapping(value = ["/{id}"])
    suspend fun deleteScript(@PathVariable id: String): ResponseEntity<RestScriptPipeline> {
        val pipeline = restScriptPipelineService.deleteScript(id)
        return ResponseEntity.ok(pipeline)
    }
}