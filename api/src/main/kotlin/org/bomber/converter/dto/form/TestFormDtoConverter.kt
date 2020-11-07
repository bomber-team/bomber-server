package org.bomber.converter.dto.form

import org.springframework.core.convert.converter.Converter
import org.bomber.api.dto.form.TestFormDto
import org.bomber.model.form.TestForm

object TestFormDtoConverter : Converter<TestForm, TestFormDto> {
    override fun convert(source: TestForm): TestFormDto {
        return TestFormDto(
            id = source.id,
            name = source.name,
            status = TestFormStatusDtoConverter.convert(source.status),
            schemaId = source.schemaId,
            scriptId = source.scriptId
        )
    }
}
