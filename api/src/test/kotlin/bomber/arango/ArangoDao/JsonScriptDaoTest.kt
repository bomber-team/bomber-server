package bomber.arango.ArangoDao

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.Rule
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.testcontainers.containers.FixedHostPortGenericContainer
import org.testcontainers.containers.output.OutputFrame
import org.testcontainers.containers.output.WaitingConsumer

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class JsonScriptDaoTest {

    private lateinit var dao: JsonScriptDao

    @Rule
    public val arangoContainer = FixedHostPortGenericContainer<Nothing>("arangodb/arangodb:3.4.4")

    private val objectMapper = ObjectMapper()

    @BeforeAll
    fun setUp() {
        arangoContainer.withEnv(mutableMapOf("ARANGO_NO_AUTH" to "0"))
        arangoContainer.withFixedExposedPort(8529, 8529)
        arangoContainer.start()
        val consumer = WaitingConsumer()
        arangoContainer.followOutput(consumer, OutputFrame.OutputType.STDOUT)
        consumer.waitUntil {
            it.utf8String.contains("ArangoDB (version 3.4.4 [linux]) is ready for business. Have fun!")
        }
        dao = JsonScriptDao()
    }

    private fun insertScript(json: MutableMap<String, Any>): String {
        val str = objectMapper.writeValueAsString(json)
        return dao.insertScript(str)
    }

    @Test
    fun testInsertScript() {
        val json = mutableMapOf<String, Any>()
        json["mac"] = "MacGenerator"
        json["val"] = "WordGenerator"
        val key = insertScript(json)

        val script = dao.getScript(key)!!

        val map = objectMapper.readValue<Map<String, Any>>(script)
        assertEquals(json["mac"], map["mac"])
        assertEquals(json["val"], map["val"])
    }

    @Test
    fun testRemoveScript() {
        val json = mutableMapOf<String, Any>()
        json["mac"] = "MacGenerator"
        json["val"] = "PasswordGenerator"
        val key = insertScript(json)

        dao.removeScript(key)
        val s = dao.getScript(key)
        assertEquals(null, s)
    }

    @Test
    fun testUpdateScript() {
        val json = mutableMapOf<String, Any>()
        json["mac"] = "MacGenerator"
        json["val"] = "PasswordGenerator"
        val key = insertScript(json)
        json["test"] = "WordGenerator"
        json["key"] = key
        val str = objectMapper.writeValueAsString(json)

        val updateKey = dao.updateScript(str)

        val document = dao.getScript(updateKey)!!
        val map = objectMapper.readValue<Map<String, Any>>(document)
        assertEquals(json["mac"], map["mac"])
        assertEquals(json["val"], map["val"])
        assertEquals(json["test"], map["test"])
    }

    @Test
    fun testGetMany() {
        val json = mutableMapOf<String, Any>()
        json["mac"] = "MacGenerator"
        json["val"] = "PasswordGenerator"

        insertScript(json)
        insertScript(json)

        val str = dao.getAllScripts(0, 2)!!

        val list = objectMapper.readValue<List<Map<String, Any>>>(str)
        assertEquals(2, list.size)
        assertEquals(json["mac"], list[0]["mac"])
        assertEquals(json["val"], list[0]["val"])
        assertEquals(json["mac"], list[1]["mac"])
        assertEquals(json["val"], list[1]["val"])
    }
}