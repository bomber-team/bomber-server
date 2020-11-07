package org.bomber.service.coroutines

import kotlinx.coroutines.CoroutineScope
import reactor.core.publisher.Mono
import reactor.util.context.Context
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.reactor.mono


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