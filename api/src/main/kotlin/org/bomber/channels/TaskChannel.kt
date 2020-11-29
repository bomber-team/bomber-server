package org.bomber.channels

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface TaskChannel {
    @Output("taskchannel")
    fun output(): MessageChannel?
}