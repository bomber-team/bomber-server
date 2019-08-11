package bomber

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.RequestParam

@SpringBootApplication
@EnableConfigServer
class Application {


    @Autowired
    lateinit var environment: Environment


    fun query(@RequestParam("bomber_id") id: String) {

    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}




