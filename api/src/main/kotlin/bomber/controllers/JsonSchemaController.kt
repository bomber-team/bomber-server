package bomber.controllers

import bomber.arango.ArangoDao.JsonSchemaDao
import org.springframework.web.bind.annotation.*

/**
 * controller for routes json scenarios
 * @author kostya05983
 */
@RestController
class JsonSchemaController {

    companion object {
        private const val API = "/jsonSchema"
        private const val API_ALL = "/jsonSchemaAll"
    }

    /**
     * Dao for connect to db
     */
    private val jsonDao: JsonSchemaDao = JsonSchemaDao()

    /**
     * Get scenario with requested key
     */
    @RequestMapping(API, method = [RequestMethod.GET])
    fun getScenario(@RequestParam(name = "id") id: String): String? {
        return jsonDao.getScheme(id)
    }

    @RequestMapping(API_ALL, method = [RequestMethod.GET])
    fun getSchemes(@RequestParam("offset") offset: Int, @RequestParam("limit") limit: Int): String? {
        return jsonDao.getAllShemas(offset, limit)
    }

    /**
     * Insert a new scenario to arango collection and return  key of new documentl
     */
    @RequestMapping(API, method = [RequestMethod.POST])
    fun createScenario(@RequestBody json: String): String {
        return jsonDao.insertShema(json)
    }

    /**
     * Update scenario which is imagined as document with request body
     */
    @RequestMapping(API, method = [RequestMethod.PUT])
    fun updateScenario(@RequestBody json: String): String {
        return jsonDao.updateShema(json)
    }

    /**
     * Delete scenario with key equals id, we don't have reverse connection
     * we need to fix it
     */
    @RequestMapping(API, method = [RequestMethod.DELETE])
    fun deleteScenario(@RequestParam("id") id: String): String {
        deleteScenario(id)
        return "maybe delete heh"
    }
}