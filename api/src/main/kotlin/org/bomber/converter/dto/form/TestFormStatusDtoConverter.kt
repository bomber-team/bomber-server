package org.bomber.converter.dto.form

import org.springframework.core.convert.converter.Converter
import org.bomber.api.dto.form.TestFormStatusDto
import org.bomber.model.form.TestFormStatus

object TestFormStatusDtoConverter : Converter<TestFormStatus, TestFormStatusDto> {
    override fun convert(source: TestFormStatus): TestFormStatusDto {
        return when (source) {
            TestFormStatus.NEW -> TestFormStatusDto.NEW
            TestFormStatus.READY -> TestFormStatusDto.READY
            TestFormStatus.IN_PROGRESS -> TestFormStatusDto.IN_PROGRESS
            TestFormStatus.ERROR -> TestFormStatusDto.ERROR
            TestFormStatus.FINISH -> TestFormStatusDto.FINISH
        }
    }
}
