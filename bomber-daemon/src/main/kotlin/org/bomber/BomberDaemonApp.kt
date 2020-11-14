package org.bomber

import org.bomber.daemons.BomberApiDaemon
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BomberDaemonApp(
    private val daemon: BomberApiDaemon
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        TODO("Not yet implemented")
    }
}

fun main(args: Array<String>) {
    runApplication<BomberDaemonApp>()
}