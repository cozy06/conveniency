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