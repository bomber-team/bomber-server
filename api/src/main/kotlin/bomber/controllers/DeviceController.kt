package bomber.controllers

import bomber.models.Device
import bomber.repository.DeviceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
class DeviceController {
    companion object {
        private const val API = "/devices"
        private const val API_ALL = "/devicesAll"
    }

    @Autowired
    private lateinit var devicesRepository: DeviceRepository

    @RequestMapping(API, method = [RequestMethod.GET])
    fun getDevice(@RequestParam("id") id: Long): Device? {
        return devicesRepository.getOne(id)
    }

    @RequestMapping(API_ALL, method = [RequestMethod.GET])
    fun getDeviceAll(@RequestParam("offset") offset: Int, limit: Int): List<Device>? {
        return devicesRepository.findAll(PageRequest.of(offset, limit)).toList()
    }

    @RequestMapping(API, method = [RequestMethod.POST])
    fun createDevice(@RequestBody json: Device): String {
        return devicesRepository.save(json).id.toString()
    }

    @RequestMapping(API, method = [RequestMethod.PUT])
    fun updateDevice(@RequestBody json: Device): String {
        return devicesRepository.save(json).id.toString()
    }

    @RequestMapping(API, method = [RequestMethod.DELETE])
    fun deleteScript(@RequestParam("id") id: Long): String {
        devicesRepository.deleteById(id)
        return "Success"
    }
}