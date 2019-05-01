package bomber.controllers

import bomber.arango.ArangoDao.JsonScenarioDao
import org.springframework.web.bind.annotation.*

/**
 * controller for routes json scenarios
 * @author kostya05983
 */
@RestController
class JsonScenarioController {

    companion object {
        private const val API = "/jsonScenario"
    }

    /**
     * Dao for connect to db
     */
    private val jsonDao: JsonScenarioDao = JsonScenarioDao()

    /**
     * Get scenario with requested key
     */
    @RequestMapping(API, method = [RequestMethod.GET])
    fun getScenario(@RequestParam(name = "id") id: String): String {
        return jsonDao.getScenario(id)
    }

    /**
     * Insert a new scenario to arango collection and return  key of new documentl
     */
    @RequestMapping(API, method = [RequestMethod.POST])
    fun createScenario(@RequestBody json: String): String {
        return jsonDao.insertScenario(json)
    }

    /**
     * Update scenario which is imagined as document with request body
     */
    @RequestMapping(API, method = [RequestMethod.PUT])
    fun updateScenario(@RequestBody json: String): String {
        return jsonDao.updateScenario(json)
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