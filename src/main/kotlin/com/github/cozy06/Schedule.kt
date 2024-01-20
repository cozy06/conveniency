package com.github.cozy06

/**
 * 스케줄 관련 타입 선언
 */
data class Schedule(
    var time: Long,
    var action: () -> Unit,
    var stop: Boolean = false
)

typealias Scheduler = MutableList<Schedule>