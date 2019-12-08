package org.bomber.service.rest.schema

import org.bomber.converter.dto.schema.RestSchemaDTOConverter
import org.bomber.converter.model.schema.BodyParamConverter
import org.bomber.converter.model.schema.RequestParamConverter
import org.bomber.dto.requests.CreateRestSchemaRequest
import org.bomber.dto.requests.UpdateRestSchemaRequest
import org.bomber.dto.schema.RestSchemaDTO
import org.bomber.dto.schema.RestSchemaItemsDTO
import org.bomber.exception.RestSchemaNotFoundException
import org.bomber.model.schema.RestSchema
import org.bomber.repository.rest.schema.RestSchemaRepository
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
            requestParams = request.requestParams.map { RequestParamConverter.convert(it) },
            body = request.body?.map { BodyParamConverter.convert(it) } ?: listOf()
        )
        val result = restSchemaRepository.saveSchema(model)
        return RestSchemaDTOConverter.convert(result)
    }

    override suspend fun updateSchema(id: String, request: UpdateRestSchemaRequest): RestSchemaDTO {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSchema(id: String): RestSchemaDTO {
        val schema = restSchemaRepository.getSchema(id)
            ?: throw RestSchemaNotFoundException(id)
        return RestSchemaDTOConverter.convert(schema)
    }

    override suspend fun getSchemes(offset: Int, limit: Int): RestSchemaItemsDTO {
        val schemas = restSchemaRepository.getSchemas()
        return RestSchemaItemsDTO(
            items = schemas.map { RestSchemaDTOConverter.convert(it) }
        )
    }

    override suspend fun deleteSchema(id: String): RestSchemaDTO {
        val deletedSchema = restSchemaRepository.deleteScheme(id)
            ?: throw RestSchemaNotFoundException(id)
        return RestSchemaDTOConverter.convert(deletedSchema)
    }
}