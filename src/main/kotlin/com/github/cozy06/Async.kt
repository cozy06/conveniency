package com.github.cozy06

import com.github.cozy06.Async.Companion.addSchedule
import kotlin.concurrent.thread

class Async {
    companion object {
        fun delay(millis: Long, function: () -> Unit) {
            thread(start = true) {
                Thread.sleep(millis)
                function()
            }
        }

        fun newScheduler(action: () -> Unit): MutableList<Schedule> {
            return mutableListOf(Schedule(0L, action))
        }

        fun MutableList<Schedule>.addSchedule(action: Schedule) {
            this.addAll(listOf(action))
        }

        fun MutableList<Schedule>.removeSchedule(index: Int) {
            if(this.size > index) {
                this.removeAt(index)
            }
            else {
                throw IllegalArgumentException("Index $index out of bounds for length ${this.size}")
            }
        }

        fun runScheduler(Schedule: Scheduler) {
            if (Schedule.isNotEmpty()) {
                thread(start = true) {
                    Thread.sleep(Schedule[0].time)
                    Schedule[0].action()
                    if(Schedule[0].stop) {
                        Schedule.removeAt(0)
                    }
                    else {
                        Schedule.removeAt(0)
                        runScheduler(Schedule)
                    }
                }
            } else {
                throw IllegalArgumentException("Schedule is Now Empty")
            }
        }

        fun stopScheduler(Schedule: Scheduler) {
            Schedule.add(0, Schedule(0L, { stop() }, true))
            Schedule[0].action()
        }

        val stop: () -> Unit = {}
    }
}