package org.bomber.service.rest.schema

import org.bomber.converter.dto.schema.RestSchemaDTOConverter
import org.bomber.converter.model.schema.RequestParamConverter
import org.bomber.api.dto.requests.CreateRestSchemaRequest
import org.bomber.api.dto.requests.UpdateRestSchemaRequest
import org.bomber.api.dto.schema.RestSchemaDTO
import org.bomber.api.dto.schema.RestSchemaItemsDto
import org.bomber.exception.RestSchemaNotFoundException
import org.bomber.model.schema.RestSchema
import org.bomber.repository.rest.schema.RestSchemaRepository
import org.bomber.repository.rest.schema.SchemaFilter
import org.springframework.stereotype.Service
import java.util.*

@Service
class RestSchemaServiceImpl(
    private val repository: RestSchemaRepository
) : RestSchemaService {
    override suspend fun create(request: CreateRestSchemaRequest): RestSchemaDTO {
        val model = RestSchema(
            id = UUID.randomUUID().toString(),
            pathVariables = request.pathVariables,
            headers = request.headers,
            requestParams = request.requestParams.map { RequestParamConverter.convert(it) },
            body = request.body
        )
        val result = repository.save(model)
        return RestSchemaDTOConverter.convert(result)
    }

    override suspend fun update(id: String, request: UpdateRestSchemaRequest): RestSchemaDTO {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun get(id: String): RestSchemaDTO {
        val schema = repository.get(id)
            ?: throw RestSchemaNotFoundException(id)
        return RestSchemaDTOConverter.convert(schema)
    }

    override suspend fun getAll(offset: Long, limit: Int): RestSchemaItemsDto {
        val filter = SchemaFilter(
            take = limit,
            skip = offset

        )
        val schemas = repository.getAll(filter)
        return RestSchemaItemsDto(
            items = schemas.map { RestSchemaDTOConverter.convert(it) }
        )
    }

    override suspend fun delete(id: String) {
        repository.delete(id)
            ?: throw RestSchemaNotFoundException(id)
    }
}