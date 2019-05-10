package bomber.controllers

import bomber.arango.ArangoDao.JsonMetricsDao
import org.springframework.web.bind.annotation.*

/**
 * Controller for collect metrics
 */
@RestController
class JsonMetricController {
    companion object {
        private const val API = "/jsonMetrics"
        private const val API_ALL = "/jsonMetricsAll"
    }

    private val jsonMetricsDao = JsonMetricsDao()

    @RequestMapping(API, method = [RequestMethod.GET])
    fun getScript(@RequestParam("id") id: String): String? {
        return jsonMetricsDao.getMetrics(id)
    }

    @RequestMapping(API_ALL, method = [RequestMethod.GET])
    fun getScriptAll(@RequestParam("offset") offset: Int, limit: Int): String? {
        return jsonMetricsDao.getAllMetrics(offset, limit)
    }

    @RequestMapping(API, method = [RequestMethod.POST])
    fun createScript(@RequestBody json: String): String {
        return jsonMetricsDao.insertMetric(json)
    }

    @RequestMapping(API, method = [RequestMethod.DELETE])
    fun deleteScript(@RequestParam("id") id: String): String {
        jsonMetricsDao.removeMetric(id)
        return "Success"
    }
}