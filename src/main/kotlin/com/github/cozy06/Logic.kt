package com.github.cozy06

class Logic {
    companion object {
        fun loop(list: MutableList<Any>, action: (Any) -> Unit) {
            repeat(list.size) {
                val index = list[it]
                action(index)
            }
        }

        fun range(startValue: Int, endValue: Int, step: Int = 1): MutableList<Any> {
            if (step == 0) throw IllegalArgumentException("Step Can't Be ZERO")
            if (step > 0 && startValue >= endValue) throw IllegalArgumentException("startValue Must be Smaller than endValue")
            if (step < 0 && startValue <= endValue) throw IllegalArgumentException("startValue Must be Bigger than endValue")
            val list: MutableList<Any> = mutableListOf()
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