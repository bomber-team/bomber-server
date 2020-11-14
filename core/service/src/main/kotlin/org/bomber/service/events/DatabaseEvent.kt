package org.bomber.service.events

import java.time.Instant

abstract class DatabaseEvent<T : Action>(
    val id: String,
    val entityId: String,
    val time: Instant = Instant.now(),
    val actions: List<T>
)

abstract class Action