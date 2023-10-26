class Solution {
    // 함수들을 이용해 짧게 짠 코드(시간은 아래코드보다 2배 걸림)
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
                var answer = intArrayOf()

        for (T in commands.indices) {
            answer += array.slice(commands[T][0] - 1 until commands[T][1]).sorted()[commands[T][2] - 1]
        }

        return answer
    }

    // 일반적인 반복문을 이용해 짠 코드
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {


        var answer = intArrayOf()

        for (T in commands.indices) {
            var temp = intArrayOf()
            for (i in commands[T][0] - 1..commands[T][1] - 1) {
                temp += array[i]
            }
            temp.sort()
            answer += temp[commands[T][2] - 1]
        }

        return answer
    }
}

