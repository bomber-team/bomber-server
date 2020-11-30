package org.bomber.consumers

import kotlinx.coroutines.runBlocking
import org.bomber.channels.DeviceChannel
import org.bomber.converter.model.BomberConverter
import org.bomber.repository.bombers.BomberRepository
import org.bomber.team.contracts.Init
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener

@EnableBinding(DeviceChannel::class)
class DeviceConsumer(
    private val bombersRepository: BomberRepository
) {
    @StreamListener("devicechannel")
    fun accept(t: ByteArray): Unit = runBlocking {
        val bomber = Init.InitBomberPayload.parseFrom(t)

        val bombers = bombersRepository.getAll(100)
        if (bombers.any { it.id.toString() == bomber.bomberId }) {
            return@runBlocking
        }

        val converted = BomberConverter.convert(bomber)
        runBlocking { bombersRepository.save(converted) }
    }
}