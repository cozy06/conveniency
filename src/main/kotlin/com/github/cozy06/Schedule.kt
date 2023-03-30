package com.github.cozy06

data class Schedule(
    val time: Long,
    val action: () -> Unit
)

typealias Scheduler = MutableList<Schedule>