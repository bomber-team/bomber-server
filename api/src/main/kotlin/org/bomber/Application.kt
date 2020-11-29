package org.bomber

import org.bomber.config.AppProperties
import org.bomber.suppliers.TaskSource
import org.bomber.team.contracts.Scheme
import org.bomber.team.contracts.Script
import org.bomber.team.contracts.TaskProto
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(AppProperties::class)
class Application(
    private val suppplier: TaskSource
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val task = TaskProto.Task.newBuilder().setSchema(Scheme.RestSchema.newBuilder().build()).setScript(
            Script.RestScript.newBuilder().build()
        ).setFormId("aaaa").build()
        suppplier.add(task)
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}