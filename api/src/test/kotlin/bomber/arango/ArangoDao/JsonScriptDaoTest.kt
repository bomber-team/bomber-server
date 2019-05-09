package bomber.arango.ArangoDao

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.codehaus.jackson.JsonParser
import org.json.JSONObject
import org.junit.Rule
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.testcontainers.containers.FixedHostPortGenericContainer

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class JsonScriptDaoTest {

    private lateinit var dao: JsonScriptDao

    @Rule
    public val arangoContainer = FixedHostPortGenericContainer<Nothing>("arangodb/arangodb:3.4.0")

    private val objectMapper = ObjectMapper()

    @BeforeAll
    fun setUp() {
        arangoContainer.withEnv(mutableMapOf("ARANGO_NO_AUTH" to "0"))
        arangoContainer.withFixedExposedPort(8529, 8529)
        arangoContainer.start()
        Thread.sleep(5000) //Костыыыыыль
        dao = JsonScriptDao()
    }

    @Test
    fun testInsertScript() {
        val json = mutableMapOf<String, Any>()
        json["mac"] = "MacGenerator"
        json["val"] = "WordGenerator"

        val str = objectMapper.writeValueAsString(json)
        val key = dao.insertScript(str)

        val script = dao.getScript(key)

        val map = objectMapper.readValue<Map<String, Any>>(script)
        assertEquals(json["mac"], map["mac"])
        assertEquals(json["val"], map["val"])
    }

}