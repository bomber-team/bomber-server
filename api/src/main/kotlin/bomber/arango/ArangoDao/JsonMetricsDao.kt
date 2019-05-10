package bomber.arango.ArangoDao

import com.arangodb.ArangoCollectionAsync
import com.arangodb.ArangoCursorAsync
import com.arangodb.ArangoDBAsync
import com.arangodb.ArangoDatabaseAsync
import com.arangodb.entity.BaseDocument
import com.arangodb.model.AqlQueryOptions
import com.arangodb.util.MapBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

/**
 * This dao is used for saving json metrics in mongo
 * @author kostya05983
 */
class JsonMetricsDao {
    companion object {
        private const val DB_NAME = "bomber"
        private const val COLLECTION_NAME = "jsonMetrics"

        private val SELECT_QUERY = """
            FOR document in jsonMetrics
            LIMIT @offset, @limit
            return document
        """.trimIndent()
    }

    private var arangoDb: ArangoDBAsync = ArangoDBAsync.Builder().host("localhost", 8529).build()
    private var db: ArangoDatabaseAsync
    private var collection: ArangoCollectionAsync
    private val objectMapper = ObjectMapper()

    init {
        if (!arangoDb.databases.get().contains(DB_NAME)) {
            arangoDb.createDatabase(DB_NAME)
        }
        db = arangoDb.db(DB_NAME)
        val collectionNames = db.collections.get().map { it.name }
        if (!collectionNames.contains(COLLECTION_NAME)) {
            db.createCollection(COLLECTION_NAME)
        }
        collection = db.collection(COLLECTION_NAME)
    }

    fun getMetrics(key: String): String? {
        val document: BaseDocument?
        document = collection.getDocument(key, BaseDocument::class.java).get() ?: return null

        val map = document.properties
        map[Fields.KEY.text] = document.key

        val mapper = ObjectMapper()
        return mapper.writeValueAsString(map)
    }

    fun getAllMetrics(offset: Int, limit: Int): String? {
        val builder = MapBuilder()
                .put(Fields.OFFSET.text, offset)
                .put(Fields.LIMIT.text, limit).get()
        val cursor: ArangoCursorAsync<BaseDocument>?
        cursor = db.query(SELECT_QUERY, builder, AqlQueryOptions(), BaseDocument::class.java).get() ?: return null

        val list = mutableListOf<BaseDocument>()
        cursor.collectInto(list)

        val listOfMaps = list.map {
            val map = it.properties
            map[Fields.KEY.text] = it.key
            map
        }
        return objectMapper.writeValueAsString(listOfMaps)
    }

    fun insertMetric(json: String): String {
        val map = objectMapper.readValue<Map<String, Any>>(json)
        val document = BaseDocument()
        document.properties = map
        return collection.insertDocument(document).get().key
    }

    fun removeMetric(key: String) {
        collection.deleteDocument(key)
    }
}