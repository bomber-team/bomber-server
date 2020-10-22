package org.bomber.consumers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.reactor.mono
import org.bomber.converter.model.ResultConverter
import org.bomber.repository.rest.result.ResultRepository
import org.bomber.team.contracts.Result
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.context.Context
import java.util.function.Consumer
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

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

    fun <T> coroutineToMono(func: suspend CoroutineScope.() -> T?): Mono<T> {
        return Mono.subscriberContext().flatMap { ctx ->
            mono(ctx.toCoroutineContext(), func)
        }
    }

    fun Context.toCoroutineContext(): CoroutineContext {
        return this.stream()
            .filter { it.value is CoroutineContext }
            .map { it.value as CoroutineContext }
            .reduce { context1, context2 -> context1 + context2 }
            .orElse(EmptyCoroutineContext)
    }
}