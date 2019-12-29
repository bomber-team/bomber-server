package org.bomber.service.rest.script.pipeline

import org.bomber.api.dto.requests.CreateScriptPipeline
import org.bomber.api.dto.requests.UpdateScriptPipeline
import org.bomber.model.script.RestScriptPipeline
import org.bomber.model.script.RestScriptPipelineItems
import org.springframework.stereotype.Service

@Service
class RestScriptPipelineServiceImpl : RestScriptPipelineService {
    override suspend fun createScriptPipeline(createRequest: CreateScriptPipeline): RestScriptPipeline {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun updateScriptPipeline(id: String, updateRequest: UpdateScriptPipeline): RestScriptPipeline {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getScriptPipeline(id: String): RestScriptPipeline {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getScriptPipelines(offset: Int, limit: Int): RestScriptPipelineItems {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteScript(id: String): RestScriptPipeline {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}