package com.github.cozy06

class Logic {
    companion object {
        /**
         * 반복문
         * @param list 실행 인덱스, 사용할 때 it 키워드 사용
         * @param action 실행 로직
         */
        fun loop(list: List<Any>, action: (Any) -> Unit) {
            repeat(list.size) {
                val index = list[it]
                action(index)
            }
        }

        /**
         * List<Int> 생성
         * @param startValue 시작 값
         * @param endValue 넘을 수 없는 수
         * @param step 증가 값,기본값 1
         * @return List<Int>을 반환
         */
        fun range(startValue: Int, endValue: Int, step: Int = 1): List<Any> {
            if (step == 0) throw IllegalArgumentException("Step Can't Be ZERO")
            if (step > 0 && startValue >= endValue) throw IllegalArgumentException("startValue Must be Smaller than endValue")
            if (step < 0 && startValue <= endValue) throw IllegalArgumentException("startValue Must be Bigger than endValue")
            val list: MutableList<Any> = mutableListOf()
            var value = startValue
            while ((step < 0 && value > endValue) || (step > 0 && value < endValue)) {
                list.add(value)
                value += step
            }
            return list.toList()
        }

        /**
         * 입력 값 받기
         * @param prints 입력 전 출력, 생략 가능
         * @return 문자열
         */
        fun input(prints: String = ""): String? {
            print(prints)
            return readLine()
        }

        /**
         * 입력 패스워드 값 받기
         * @param prints 입력 전 출력, 생략 가능
         * @return 패스워드 문자열
         */
        fun inputPW(prints: String = ""): String? {
            print(prints)
            return (System.console()?.readPassword() ?: readLine()).toString()
        }
    }
}