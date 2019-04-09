package bomber.ArangoDao

import com.arangodb.ArangoCollectionAsync
import com.arangodb.ArangoDBAsync
import com.arangodb.ArangoDatabaseAsync
import com.arangodb.entity.BaseDocument

/**
 * This dao is responsible for crud operation scnearios
 */
class ScenarioDao {
    companion object {
        const val DB_NAME = "bomber"
        const val COLLECTION_NAME = "jsonRestCollection"
    }

    private var arangoDb: ArangoDBAsync = ArangoDBAsync.Builder().build()
    private var db: ArangoDatabaseAsync
    private var collection: ArangoCollectionAsync

    init {
        arangoDb.db(DB_NAME).drop().get()
        arangoDb.createDatabase(DB_NAME).get()
        db = arangoDb.db(DB_NAME)
        db.createCollection(COLLECTION_NAME).get()
        collection = db.collection(COLLECTION_NAME)
    }


    public fun downDao() {
        db.drop().get()
        arangoDb.shutdown()
    }


    public fun insertScenario() {
        val value = BaseDocument()

    }
}