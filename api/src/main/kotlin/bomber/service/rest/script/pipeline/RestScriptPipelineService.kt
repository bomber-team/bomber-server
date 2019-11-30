package bomber.service.rest.script.pipeline

import bomber.dto.requests.CreateScriptPipeline
import bomber.dto.requests.UpdateScriptPipeline
import bomber.model.script.RestScriptPipeline
import bomber.model.script.RestScriptPipelineItems

interface RestScriptPipelineService {
    suspend fun createScriptPipeline(createRequest: CreateScriptPipeline): RestScriptPipeline

    suspend fun updateScriptPipeline(id: String, updateRequest: UpdateScriptPipeline): RestScriptPipeline

    suspend fun getScriptPipeline(id: String): RestScriptPipeline

    suspend fun getScriptPipelines(offset: Int, limit: Int): RestScriptPipelineItems

    suspend fun deleteScript(id: String): RestScriptPipeline
}