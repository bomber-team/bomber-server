package bomber.arango.ArangoDao

import com.arangodb.ArangoCollectionAsync
import com.arangodb.ArangoDBAsync
import com.arangodb.ArangoDatabaseAsync
import com.arangodb.entity.BaseDocument
import com.arangodb.model.AqlQueryOptions
import com.arangodb.util.MapBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

/**
 * This dao is responsible for crud operation scenarious
 * @author kostya05983
 */
class JsonScenarioDao {
    companion object {
        private const val DB_NAME = "bomber"
        private const val COLLECTION_NAME = "jsonRestCollection"

        private const val SELECT_QUERY = "FOR document in jsonRestCollection LIMIT @@offset @@limit return t"
    }

    private var arangoDb: ArangoDBAsync = ArangoDBAsync.Builder().build()
    private var db: ArangoDatabaseAsync
    private var collection: ArangoCollectionAsync
    private val objectMapper = ObjectMapper()

    init {
        arangoDb.createDatabase(DB_NAME).get()
        db = arangoDb.db(DB_NAME)
        db.createCollection(COLLECTION_NAME).get()
        collection = db.collection(COLLECTION_NAME)
    }

    private enum class VarFields(val text: String) {
        Limit("@limit"), Offset("@offset"),
        Key("key")
    }

    /**
     * Down our dao for scenarious interrupt connections and so on
     */
    fun downDao() {
        db.drop().get()
        arangoDb.shutdown()
    }

    /**
     * Get scenario by id
     */
    fun getScenario(id: String): String {
        val document = collection.getDocument(id, BaseDocument::class.java).get()

        val map = document.properties
        map[VarFields.Key.text] = document.key

        val mapper = ObjectMapper()
        return mapper.writeValueAsString(map)
    }

    /**
     * We can use block operation as spring creates multithreading for us
     * @param offset - how many documents wem mskip from query
     * @param limit - maximum documents to return
     * @return - string with array of json's objects
     */
    fun getAllScenarious(offset: Int, limit: Int): String {
        val builder = MapBuilder().put(VarFields.Offset.text, offset)
                .put(VarFields.Limit.text, limit).get()

        val cursorAsync = db.query(SELECT_QUERY, builder, AqlQueryOptions(), BaseDocument::class.java).get()

        val list = mutableListOf<BaseDocument>()
        cursorAsync.collectInto(list)

        val listOfMaps = list.map {
            val map = it.properties
            map[VarFields.Key.text] = it.key
            objectMapper.writeValueAsString(map)
        }
        return objectMapper.writeValueAsString(listOfMaps)
    }

    /**
     * We can use blocking api, 'cause spring creates multithreading for us
     * @param json - request body, from this we get our scanrio with object mapper
     * @return - key of new inserted document
     */
    fun insertScenario(json: String): String {
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
    fun removeScenario(key: String) {
        collection.deleteDocument(key)
    }

    /**
     * Use blocking api, 'cause spring creates multithreading for us
     * @param json - request body, contains new value for document
     * @return - key of updated document
     */
    fun updateScenario(json: String): String {
        val map = objectMapper.readValue<Map<String, Any>>(json)
        val document = BaseDocument()
        document.properties = map
        return collection.updateDocument(map[VarFields.Key.text] as String, document).get().key
    }
}