package bomber.models

import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class JsonScenario(
        @Id
        var id: Long,
//        @Convert(converter = HashMapConverter::class.java)
        var customAttributes: Map<String, Any>
)