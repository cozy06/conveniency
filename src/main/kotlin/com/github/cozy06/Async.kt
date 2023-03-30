package com.github.cozy06

import kotlin.concurrent.thread

class Async {
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
        this.removeAt(index)
    }

    fun runScheduler(Schedule: Scheduler) {
        if(Schedule.isNotEmpty()) {
            thread(start = true) {
                Thread.sleep(Schedule[0].time)
                Schedule[0].action()
                Schedule.removeAt(0)
                runScheduler(Schedule)
            }
        }
        else {
            throw IllegalArgumentException("Schedule is Now Empty")
        }
    }
}