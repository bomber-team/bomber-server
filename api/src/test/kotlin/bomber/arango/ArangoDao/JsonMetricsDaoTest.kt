package bomber.arango.ArangoDao

import org.junit.Rule
import org.junit.jupiter.api.Assertions.*
import com.fasterxml.jackson.module.kotlin.readValue

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.testcontainers.containers.FixedHostPortGenericContainer
import org.testcontainers.containers.output.OutputFrame
import org.testcontainers.containers.output.WaitingConsumer
import java.time.LocalDate

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class JsonMetricsDaoTest {

    private lateinit var dao: JsonMetricsDao

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
        dao = JsonMetricsDao()
    }

    private fun insertMetrics(json: MutableMap<String, Any>): String {
        val str = objectMapper.writeValueAsString(json)
        return dao.insertMetric(str)
    }

    @Test
    fun testInsertMetric() {
        val json = mutableMapOf<String, Any>()
        json["metrics"] = arrayListOf(123, 234, 546)
        json["date"] = LocalDate.now()
        val key = insertMetrics(json)

        val metric = dao.getMetrics(key)!!

        val map = objectMapper.readValue<Map<String, Any>>(metric)
        assertEquals(json["metrics"], map["metrics"])
        assertNotNull(json["date"])
    }

    @Test
    fun testRemoveMetric() {
        val json = mutableMapOf<String, Any>()
        json["metrics"] = arrayListOf(123, 234, 546)
        json["date"] = LocalDate.now()
        val key = insertMetrics(json)

        dao.removeMetric(key)
        val s = dao.getMetrics(key)
        assertEquals(null, s)
    }

    @Test
    fun testGetMany() {
        val json = mutableMapOf<String, Any>()
        json["metrics"] = arrayListOf(123, 234, 546)
        json["date"] = LocalDate.now()

        insertMetrics(json)
        insertMetrics(json)

        val str = dao.getAllMetrics(0, 2)!!

        val list = objectMapper.readValue<List<Map<String, Any>>>(str)
        assertEquals(2, list.size)
        assertEquals(json["metrics"], list[0]["metrics"])
        assertEquals(json["metrics"], list[1]["metrics"])
    }
}