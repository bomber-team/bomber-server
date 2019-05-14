package bomber.controllers

import bomber.arango.ArangoDao.JsonScriptDao
import bomber.arango.ArangoDao.ScriptFields
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AttackController {
    companion object {
        private const val API = "/attack"
    }

    private val dao = JsonScriptDao()
    private val list = ArrayList<String>()

    @RequestMapping(API, method = [RequestMethod.GET])
    fun attack(@RequestParam("id") id: String): String {
        val script = dao.getScriptAsMap(id) ?: return "Script not found"
        val ips = script[ScriptFields.ATTACKERS_IPS.text] ?: return "Ips not found"

        list.add(id)
        return "Attack started"
    }

    /**
     * TODO bug case, user start attack, change script, next stop attack, attack isn't stopper
     *  I think we need to cache our script in attack or just their addresses
     */
    @RequestMapping(API, method = [RequestMethod.DELETE])
    fun stopAttack(@RequestParam("id") id: String): String {
        if (!list.contains(id)) {
            return "Not found in queue"
        }

        val script = dao.getScriptAsMap(id) ?: return "Script not found"
        val ips = script[ScriptFields.ATTACKERS_IPS.text] ?: return "Ips not found"

        //TODO send signal to devices
        list.remove(id)
        return "Success"
    }
}