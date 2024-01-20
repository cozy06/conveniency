package com.github.cozy06

class Logic {
    companion object {
        fun loop(action: (Int) -> Unit, times: Int, startValue: Int = 0, step: Int = 1) {
            if (step == 0) throw IllegalArgumentException("Step Can't Be ZERO")
            var index = startValue
            if (step < 0) {
                while (times * step + startValue < index) {
                    action(index)
                    index += step
                }
            } else {
                while (times * step + startValue > index) {
                    action(index)
                    index += step
                }
            }
        }

        fun range(startValue: Int, endValue: Int, step: Int = 1): MutableList<Int> {
            if (step == 0) throw IllegalArgumentException("Step Can't Be ZERO")
            if (step > 0 && startValue >= endValue) throw IllegalArgumentException("startValue Must be Smaller than endValue")
            if (step < 0 && startValue <= endValue) throw IllegalArgumentException("startValue Must be Bigger than endValue")
            val list: MutableList<Int> = mutableListOf()
            var value = startValue
            while ((step < 0 && value > endValue) || (step > 0 && value < endValue)) {
                list.add(value)
                value += step
            }
            return list
        }

        fun input(prints: String = ""): String? {
            print(prints)
            return readLine()
        }

        fun inputPW(prints: String = ""): String? {
            print(prints)
            return (System.console()?.readPassword() ?: readLine()).toString()
        }
    }
}