package org.springframework.cloud.config.server.arango.environment

import com.arangodb.ArangoCollectionAsync
import com.arangodb.ArangoDBAsync
import com.arangodb.entity.BaseDocument
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.WebApplicationType
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.cloud.config.server.arango.config.ArangoEnvironmentRepositoryConfiguration
import org.springframework.cloud.config.server.environment.EnvironmentRepository
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.testcontainers.containers.FixedHostPortGenericContainer
import org.testcontainers.containers.output.OutputFrame
import org.testcontainers.containers.output.WaitingConsumer

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ArangoEnvironmentRepositoryTest {

    @Rule
    public val arangoContainer = FixedHostPortGenericContainer<Nothing>("arangodb/arangodb:3.4.4")

    private lateinit var collection: ArangoCollectionAsync

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
        initDatabases()
    }

    private fun initDatabases() {
        val arangoDb = ArangoDBAsync.Builder().host("localhost", 8529).build()
        if (!arangoDb.databases.get().contains("bomber")) {
            arangoDb.createDatabase("bomber")
        }
        val db = arangoDb.db("bomber")
        val collectionNames = db.collections.get().map { it.name }
        if (!collectionNames.contains("scheme")) {
            db.createCollection("scheme")
        }
        collection = db.collection("scheme")
    }

    @Test
    fun defaultRepo() {
        val props = hashMapOf<String, Any>()
        val context = SpringApplicationBuilder(TestConfiguration::class.java).web(WebApplicationType.NONE)
                .properties(props).run()

        val repository = context.getBean(EnvironmentRepository::class.java)

        val document = BaseDocument()
        document.addAttribute("bomber_id", "test")
        document.addAttribute("test", "test1")
        collection.insertDocument(document).get()

        val one = repository.findOne("bomber", "scheme", null)
        val get = one.propertySources.filter { it.name == "test" }[0].source.get("test")
        assertEquals("test1", get)
    }

    @Configuration
    @Import(ArangoEnvironmentRepositoryConfiguration::class)
    @EnableConfigServer
    internal class TestConfiguration
}