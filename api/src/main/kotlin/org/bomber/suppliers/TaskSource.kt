package org.bomber.suppliers

import org.bomber.channels.TaskChannel
import org.bomber.team.contracts.TaskProto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.messaging.support.MessageBuilder

@EnableBinding(TaskChannel::class)
class TaskSource {
    @Autowired
    private lateinit var taskChannel: TaskChannel

    fun add(task: TaskProto.Task) {
        taskChannel.output()?.send(MessageBuilder.withPayload(task.toByteArray()).build())
    }
}