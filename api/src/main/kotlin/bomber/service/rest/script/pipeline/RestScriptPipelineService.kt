package bomber.service.rest.script.pipeline

import bomber.dto.requests.CreateScriptPipeline
import bomber.dto.requests.UpdateScriptPipeline
import bomber.dto.script.RestScriptPipelineDTO
import bomber.dto.script.RestScriptPipelineItemsDTO

interface RestScriptPipelineService {
    suspend fun createScriptPipeline(createRequest: CreateScriptPipeline): RestScriptPipelineDTO

    suspend fun updateScriptPipeline(id: String, updateRequest: UpdateScriptPipeline): RestScriptPipelineDTO

    suspend fun getScriptPipeline(id: String): RestScriptPipelineDTO

    suspend fun getScriptPipelines(offset: Int, limit: Int): RestScriptPipelineItemsDTO

    suspend fun deleteScript(id: String): RestScriptPipelineDTO
}