package org.bomber.service.daemons

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class AbstractDaemonWorker(
    private val properties: DaemonProperties
) {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.java)

    private var job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) { run(this) }

    suspend fun start() {
        logger.info("Start worker")

        job.start()

        job.invokeOnCompletion {
            logger.error("Error occurred $it")
        }
    }

    abstract suspend fun run(scope: CoroutineScope)

    suspend fun stop() {
        job.cancel()
    }
}