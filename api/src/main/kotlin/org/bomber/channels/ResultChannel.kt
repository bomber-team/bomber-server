package org.bomber.channels

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.SubscribableChannel

interface ResultChannel {
    @Input("resultchannel")
    fun input(): SubscribableChannel
}