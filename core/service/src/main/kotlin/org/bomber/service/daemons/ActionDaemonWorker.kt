package org.bomber.service.daemons

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlin.coroutines.coroutineContext

abstract class ActionDaemonWorker(
    private val properties: DaemonProperties
) : AbstractDaemonWorker(properties) {

    override suspend fun run(scope: CoroutineScope) {
        while (coroutineContext.isActive) {
            try {
                doAction()
                delay(properties.delay.toMillis())
            } catch (ex: Exception) {
                logger.error("Exception occurred while action ex=$ex")
                delay(properties.errorDelay.toMillis())
            }
        }
    }

    abstract suspend fun doAction()
}