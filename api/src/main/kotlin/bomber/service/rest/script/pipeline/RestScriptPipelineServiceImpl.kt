package bomber.service.rest.script.pipeline

import bomber.dto.requests.CreateScriptPipeline
import bomber.dto.requests.UpdateScriptPipeline
import bomber.dto.script.RestScriptPipelineDTO
import bomber.dto.script.RestScriptPipelineItemsDTO
import org.springframework.stereotype.Service

@Service
class RestScriptPipelineServiceImpl : RestScriptPipelineService {
    override suspend fun createScriptPipeline(createRequest: CreateScriptPipeline): RestScriptPipelineDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun updateScriptPipeline(id: String, updateRequest: UpdateScriptPipeline): RestScriptPipelineDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getScriptPipeline(id: String): RestScriptPipelineDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getScriptPipelines(offset: Int, limit: Int): RestScriptPipelineItemsDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteScript(id: String): RestScriptPipelineDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}