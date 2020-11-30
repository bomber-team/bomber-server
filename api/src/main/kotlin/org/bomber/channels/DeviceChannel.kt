package org.bomber.channels

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.SubscribableChannel

interface DeviceChannel {
    @Input("devicechannel")
    fun input(): SubscribableChannel
}