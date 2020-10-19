package org.bomber.consumers

import org.bomber.team.contracts.Result
import java.util.function.Consumer

class ResultConsumer : Consumer<ByteArray> {
    override fun accept(t: ByteArray) {
        val result = Result.BomberResult.parseFrom(t)

    }
}