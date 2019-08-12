package bomber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.cloud.config.server.arango.config.ArangoEnvironmentRepositoryConfiguration
import org.springframework.context.annotation.Import
import org.springframework.web.bind.annotation.RequestParam

@SpringBootApplication
@EnableConfigServer
@Import(ArangoEnvironmentRepositoryConfiguration::class)
class Application {
    fun query(@RequestParam("bomber_id") id: String) {
        TODO("Not imnplemented, logic for select specified config")
    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}




