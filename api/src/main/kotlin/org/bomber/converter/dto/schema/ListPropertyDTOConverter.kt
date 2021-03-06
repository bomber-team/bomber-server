package org.bomber.converter.dto.schema

import org.bomber.api.dto.schema.ListPropertyDTO
import org.bomber.api.dto.schema.SimplePropertyDTO
import org.bomber.model.schema.ListProperty
import org.bomber.model.schema.ObjectProperty
import org.springframework.core.convert.converter.Converter

object ListPropertyDTOConverter : Converter<ListProperty<*>, ListPropertyDTO<*>> {
    override fun convert(source: ListProperty<*>): ListPropertyDTO<*> {
        return if (source.value.isNotEmpty()) {
            when (source.value[0].value) {
                is String -> {
                    convertGeneric(source as ListProperty<String>)
                }
                is Long -> {
                    convertGeneric(source as ListProperty<Long>)
                }
                is ObjectProperty -> {
                    convertGeneric(source as ListProperty<ObjectProperty>)
                }
                else -> {
                    throw IllegalArgumentException("Such type isn't supported")
                }
            }
        } else {
            ListPropertyDTO<Any>(
                name = source.name,
                isGenerated = source.isGenerated,
                config = source.config?.let { GeneratorConfigDTOConverter.convert(it) },
                value = listOf()
            )
        }
    }

    private fun <T> convertGeneric(source: ListProperty<T>): ListPropertyDTO<T> {
        return ListPropertyDTO(
            name = source.name,
            isGenerated = source.isGenerated,
            config = source.config?.let { GeneratorConfigDTOConverter.convert(it) },
            value = source.value.map { SimplePropertyDTOConverter.convert(it) as SimplePropertyDTO<T> }
        )
    }
}