package org.bomber.service.rest.script.pipeline

import org.bomber.dto.requests.CreateScriptPipeline
import org.bomber.dto.requests.UpdateScriptPipeline
import org.bomber.model.script.RestScriptPipeline
import org.bomber.model.script.RestScriptPipelineItems

interface RestScriptPipelineService {
    suspend fun createScriptPipeline(createRequest: CreateScriptPipeline): RestScriptPipeline

    suspend fun updateScriptPipeline(id: String, updateRequest: UpdateScriptPipeline): RestScriptPipeline

    suspend fun getScriptPipeline(id: String): RestScriptPipeline

    suspend fun getScriptPipelines(offset: Int, limit: Int): RestScriptPipelineItems

    suspend fun deleteScript(id: String): RestScriptPipeline
}