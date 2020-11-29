package org.bomber.consumers

import kotlinx.coroutines.runBlocking
import org.bomber.channels.ResultChannel
import org.bomber.converter.model.ResultConverter
import org.bomber.repository.rest.result.ResultRepository
import org.bomber.team.contracts.Result
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener

@EnableBinding(ResultChannel::class)
class ResultConsumer(
    private val resultRepository: ResultRepository
) {
    @StreamListener("resultchannel")
    fun accept(t: ByteArray) {
        val result = Result.BomberResult.parseFrom(t)
        val modelResult = ResultConverter.convert(result)
        runBlocking { resultRepository.save(modelResult) } // TODO позже перейти на flux
    }
}