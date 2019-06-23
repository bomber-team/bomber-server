package bomber.arango.ArangoDao

import com.arangodb.*
import com.arangodb.entity.BaseDocument
import com.arangodb.model.AqlQueryOptions
import com.arangodb.util.MapBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

/**
 * This dao is responsible for crud operation scenarious
 * @author kostya05983
 */
class JsonSchemaDao {
    companion object {
        private const val DB_NAME = "bomber"
        private const val COLLECTION_NAME = "jsonRestSchema"

        private const val SELECT_QUERY = "FOR document in jsonRestSchema LIMIT @offset, @limit return document"
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

    /**
     * Get schema by key
     */
    fun getScheme(key: String): String? {
        val document = collection.getDocument(key, BaseDocument::class.java).getNow(null) ?: return null

        val map = document.properties
        map[Fields.KEY.text] = document.key

        val mapper = ObjectMapper()
        return mapper.writeValueAsString(map)
    }

    /**
     * We can use block operation as spring creates multithreading for us
     * @param offset - how many documents wem mskip from query
     * @param limit - maximum documents to return
     * @return - string with array of json's objects
     */
    fun getAllShemas(offset: Int, limit: Int): String? {
        val builder = MapBuilder().put(Fields.OFFSET.text, offset)
                .put(Fields.LIMIT.text, limit).get()

        val cursorAsync = db.query(SELECT_QUERY, builder, AqlQueryOptions(), BaseDocument::class.java)
                .getNow(null) ?: return null

        val list = mutableListOf<BaseDocument>()
        cursorAsync.collectInto(list)

        val listOfMaps = list.map {
            val map = it.properties
            map[Fields.KEY.text] = it.key
            objectMapper.writeValueAsString(map)
        }
        return objectMapper.writeValueAsString(listOfMaps)
    }

    /**
     * We can use blocking api, 'cause spring creates multithreading for us
     * @param json - request body, from this we get our scanrio with object mapper
     * @return - key of new inserted document
     */
    fun insertShema(json: String): String {
        val map = objectMapper.readValue<Map<String, Any>>(json)
        val document = BaseDocument()
        document.properties = map
        return collection.insertDocument(document).get().key
    }

    /**
     * Just delete document in db, we need reverse connection
     * but what can we return?
     * @param key - the document's key unique
     */
    fun removeShema(key: String) {
        collection.deleteDocument(key)
    }

    /**
     * Use blocking api, 'cause spring creates multithreading for us
     * @param json - request body, contains new value for document
     * @return - key of updated document
     */
    fun updateShema(json: String): String {
        val map = objectMapper.readValue<Map<String, Any>>(json)
        val document = BaseDocument()
        document.properties = map
        return collection.updateDocument(map[Fields.KEY.text] as String, document).get().key
    }
}