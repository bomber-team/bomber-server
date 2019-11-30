package bomber.service.rest.schema

import bomber.dto.requests.CreateRestSchemaRequest
import bomber.dto.requests.UpdateRestSchemaRequest
import bomber.dto.schema.RestSchemaDTO
import bomber.dto.schema.RestSchemaItemsDTO
import bomber.model.schema.RestSchema
import bomber.repository.rest.schema.RestSchemaRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RestSchemaServiceImpl(
    private val restSchemaRepository: RestSchemaRepository
) : RestSchemaService {
    override suspend fun createSchema(request: CreateRestSchemaRequest): RestSchemaDTO {
        val model = RestSchema(
            id = UUID.randomUUID().toString(),
            pathVariables = request.pathVariables,
            headers = request.headers,
            requestParams = request.requestParams,
            body = request.body
        )
        val result = restSchemaRepository.saveSchema(model)
        return RestSChemaDTOConverter.convert(result)
    }

    override suspend fun updateSchema(id: String, request: UpdateRestSchemaRequest): RestSchemaDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSchema(id: String): RestSchemaDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSchemes(offset: Int, limit: Int): RestSchemaItemsDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteSchema(id: String): RestSchemaDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}