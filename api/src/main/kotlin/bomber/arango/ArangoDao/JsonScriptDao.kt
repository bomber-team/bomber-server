package bomber.arango.ArangoDao

import com.arangodb.*
import com.arangodb.entity.BaseDocument
import com.arangodb.model.AqlQueryOptions
import com.arangodb.util.MapBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

/**
 * now this class similar to jsonSchemaDao, because we don't know anything about fields
 * but in a future, when we will connect it to web, class will have been changed
 * @author kostya05983
 */
class JsonScriptDao {
    companion object {
        private const val DB_NAME = "bomber"
        private const val COLLECTION_NAME = "jsonScripts"

        private  val SELECT_QUERY ="""
            FOR document in jsonScripts
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

    private enum class VarField(val text: String) {
        LIMIT("limit"), OFFSET("offset"),
        KEY("key")
    }

    fun getScript(id: String): String? {
        val document: BaseDocument?
        document = collection.getDocument(id, BaseDocument::class.java).get() ?: return null

        val map = document.properties
        map[VarField.KEY.text] = document.key

        val mapper = ObjectMapper()
        return mapper.writeValueAsString(map)
    }

    fun getAllScripts(offset: Int, limit: Int): String? {
        val builder = MapBuilder()
                .put(VarField.OFFSET.text, offset)
                .put(VarField.LIMIT.text, limit).get()
        val cursor: ArangoCursorAsync<BaseDocument>?
        cursor = db.query(SELECT_QUERY, builder, AqlQueryOptions(), BaseDocument::class.java).get() ?: return null

        val list = mutableListOf<BaseDocument>()
        cursor.collectInto(list)

        val listOfMaps = list.map {
            val map = it.properties
            map[VarField.KEY.text] = it.key
            map
        }
        return objectMapper.writeValueAsString(listOfMaps)
    }

    fun insertScript(json: String): String {
        val map = objectMapper.readValue<Map<String, Any>>(json)
        val document = BaseDocument()
        document.properties = map
        return collection.insertDocument(document).get().key
    }

    fun removeScript(key: String) {
        collection.deleteDocument(key)
    }

    fun updateScript(json: String): String {
        val map = objectMapper.readValue<Map<String, Any>>(json)
        val document = BaseDocument()
        document.properties = map
        return collection.updateDocument(map[VarField.KEY.text] as String, document).get().key
    }
}