package org.bomber.suppliers

import io.nats.client.Nats
import org.bomber.channels.TaskChannel
import org.bomber.team.contracts.TaskProto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import java.time.Duration
import java.util.*

@EnableBinding(TaskChannel::class)
class TaskSource {
    @Autowired
    private lateinit var taskChannel: TaskChannel
    private val nats = Nats.connect("nats://172.17.0.3:4222");

    fun add(bomberId: UUID, task: TaskProto.Task) {
//        val nats = Nats.connect("nats://25.53.4.151:4222");
        nats.publish("bombers.tasks.$bomberId", task.toByteArray())
        nats.flush(Duration.ZERO)
//        nats.close()
//        taskChannel.output()?.send(MessageBuilder.withPayload(task.toByteArray()).build())
    }
}