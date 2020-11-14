package org.bomber.model.form

import org.bomber.service.events.Action
import org.bomber.service.events.DatabaseEvent
import java.time.Instant

class FormDatabaseEvent(
    id: String,
    entityId: String,
    actions: List<FormAction>
) : DatabaseEvent<FormAction>(
    id,
    entityId,
    Instant.now(),
    actions
)

sealed class FormAction : Action()

data class RunFormAction(
    val scriptId: String,
    val schemaId: String
) : FormAction()