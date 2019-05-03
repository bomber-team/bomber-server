package bomber.controllers

import bomber.arango.ArangoDao.JsonScriptDao
import org.springframework.web.bind.annotation.*

/**
 * Controller for json scripts
 * describing the  restful test
 */
@RestController
class JsonScriptController {
    companion object {
        private const val API = "/jsonScript"
        private const val API_ALL = "/jsonScriptAll"
    }

    private val jsonScriptDao = JsonScriptDao()

    @RequestMapping(API, method = [RequestMethod.GET])
    fun getScript(@RequestParam("id") id: String): String {
        return jsonScriptDao.getScript(id)
    }

    @RequestMapping(API_ALL, method = [RequestMethod.GET])
    fun getScriptAll(@RequestParam("offset") offset: Int, limit: Int): String {
        return jsonScriptDao.getAllScripts(offset, limit)
    }

    @RequestMapping(API, method = [RequestMethod.POST])
    fun createScript(@RequestBody json: String): String {
        return jsonScriptDao.insertScript(json)
    }

    @RequestMapping(API, method = [RequestMethod.PUT])
    fun updateScript(@RequestBody json: String): String {
        return jsonScriptDao.updateScript(json)
    }

    @RequestMapping(API, method = [RequestMethod.DELETE])
    fun deleteScript(@RequestParam("id") id: String): String {
        jsonScriptDao.removeScript(id)
        return "Success"
    }
}