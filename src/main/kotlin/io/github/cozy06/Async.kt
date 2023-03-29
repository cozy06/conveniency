package io.github.cozy06

import kotlin.concurrent.thread

class Async {
    fun delay(millis: Long, function: () -> Unit, repeat: Int = 1) {
        thread(start = true) {
            for(i: Int in 1..repeat) {
                Thread.sleep(millis)
                function()
            }
        }
    }
}