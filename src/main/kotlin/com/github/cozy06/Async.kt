package com.github.cozy06

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

        fun Scheduler.addSchedule(schedules: Schedule) {
            this.addAll(listOf(schedules))
        }

        fun Scheduler.removeSchedule(index: Int) {
            if(this.size > index) {
                this.removeAt(index)
            }
            else {
                throw IllegalArgumentException("Index $index out of bounds for length ${this.size}")
            }
        }

        fun Scheduler.insertScheduler(index: Int, Schedules: Schedule) {
            this.add(index, Schedules)
        }

        fun Scheduler.editSchedule(index: Int, Schedules: Schedule) {
            this[index] = Schedules
        }

        fun runScheduler(schedules: Scheduler) {
            if (schedules.isNotEmpty()) {
                thread(start = true) {
                    Thread.sleep(schedules[0].time)
                    schedules[0].action()
                    if(schedules[0].stop) {
                        schedules[0].stop = false
                    }
                    else {
                        schedules.removeAt(0)
                        runScheduler(schedules)
                    }
                }
            } else {
                throw IllegalArgumentException("Schedule is Now Empty")
            }
        }

        fun stopScheduler(Schedules: Scheduler) {
            Schedules[0].stop = true
        }
    }
}