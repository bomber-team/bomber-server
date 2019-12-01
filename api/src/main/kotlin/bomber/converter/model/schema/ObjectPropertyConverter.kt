package bomber.converter.model.schema

import bomber.dto.schema.ObjectPropertyDTO
import bomber.model.schema.ObjectProperty
import org.springframework.core.convert.converter.Converter

object ObjectPropertyConverter : Converter<ObjectPropertyDTO, ObjectProperty> {
    override fun convert(source: ObjectPropertyDTO): ObjectProperty {
        return ObjectProperty(
            name = source.name,
            isGenerated = source.isGenerated,
            generatorType = source.generatorType?.let { GeneratorTypeConverter.convert(it) },
            config = source.config?.let { GeneratorConfigConverter.convert(it) },
            properties = source.properties.mapValues { BodyParamConverter.convert(it.value) }
        )
    }
}