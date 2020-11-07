package org.bomber.consumers

import org.bomber.converter.model.ResultConverter
import org.bomber.repository.rest.result.ResultRepository
import org.bomber.service.coroutines.coroutineToMono
import org.bomber.team.contracts.Result
import reactor.core.publisher.Flux
import java.util.function.Consumer

class ResultConsumer(
    private val resultRepository: ResultRepository
) : Consumer<Flux<ByteArray>> {
    override fun accept(t: Flux<ByteArray>) {
        t.flatMap {
            coroutineToMono {
                val result = Result.BomberResult.parseFrom(it)
                val modelResult = ResultConverter.convert(result)
                resultRepository.save(modelResult)
            }
        }.subscribe()
    }
}