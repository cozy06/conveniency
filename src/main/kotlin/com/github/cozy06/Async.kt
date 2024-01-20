package com.github.cozy06

import kotlin.concurrent.thread

class Async {
    companion object {
        /**
         * 딜레이
         * @param millis Long 타입으로 딜레이 시간
         * @param function 실행 로직
         */
        fun delay(millis: Long, function: () -> Unit) {
            thread(start = true) {
                Thread.sleep(millis)
                function()
            }
        }

        /**
         * 비동기 실행
         * @param function 실행 로직
         */
        fun async(function: () -> Unit) {
            thread(start = true) {
                function()
            }
        }

        /**
         * 새 스케줄러 생성
         * @param action 실행 로직
         */
        fun newScheduler(action: () -> Unit): MutableList<Schedule> {
            return mutableListOf(Schedule(0L, action))
        }

        /**
         * 스케줄러 추가
         * @param schedules 실행 로직
         */
        fun Scheduler.addSchedule(schedules: Schedule) {
            this.addAll(listOf(schedules))
        }

        /**
         * 스케줄러 제거
         * @param index 제거 인덱스
         */
        fun Scheduler.removeSchedule(index: Int) {
            if(this.size > index) {
                this.removeAt(index)
            }
            else {
                throw IllegalArgumentException("Index $index out of bounds for length ${this.size}")
            }
        }

        /**
         * 스케줄러 삽입
         * @param schedules 실행 로직
         * @param index 삽입 위치
         */
        fun Scheduler.insertScheduler(index: Int, schedules: Schedule) {
            this.add(index, schedules)
        }

        /**
         * 스케줄러 수정
         * @param schedules 실행 로직
         * @param index 수정 위치
         */
        fun Scheduler.editSchedule(index: Int, schedules: Schedule) {
            this[index] = schedules
        }

        /**
         * 스케줄러 실행
         * @param schedules 스케줄러
         */
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

        /**
         * 스케줄러 정지
         * @param schedules 스케줄러
         */
        fun stopScheduler(schedules: Scheduler) {
            schedules[0].stop = true
        }
    }
}