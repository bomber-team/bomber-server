package bomber.service.rest.schema

import bomber.dto.requests.CreateRestSchemaRequest
import bomber.dto.requests.UpdateRestSchemaRequest
import bomber.dto.schema.RestSchemaDTO
import bomber.dto.schema.RestSchemaItemsDTO
import org.springframework.stereotype.Service

@Service
class RestSchemaServiceImpl : RestSchemaService {
    override suspend fun createSchema(request: CreateRestSchemaRequest): RestSchemaDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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