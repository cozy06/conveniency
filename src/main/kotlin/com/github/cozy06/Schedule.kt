package com.github.cozy06

data class Schedule(
    val time: Long,
    val action: () -> Unit,
    var stop: Boolean = false
)

typealias Scheduler = MutableList<Schedule>