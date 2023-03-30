package com.github.cozy06

data class Schedule(
    var time: Long,
    var action: () -> Unit,
    var stop: Boolean = false
)

typealias Scheduler = MutableList<Schedule>