package bomber.service.rest.script.pipeline

import bomber.dto.requests.CreateScriptPipeline
import bomber.dto.requests.UpdateScriptPipeline
import bomber.model.script.RestScriptPipeline
import bomber.model.script.RestScriptPipelineItems
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