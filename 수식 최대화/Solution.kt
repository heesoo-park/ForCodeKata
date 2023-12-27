import kotlin.math.abs

class Solution {
    fun solution(expression: String): Long {
        var answer: Long = 0
        val case = listOf(listOf('+', '-', '*'), listOf('+', '*', '-'), listOf('-', '+', '*'), listOf('-', '*', '+'), listOf('*', '-', '+'), listOf('*', '+', '-'))
        val numberInput = expression.split(Regex("[-+*]")).map { it.toLong() }
        val operationInput = expression.filter { it == '-' || it == '+' || it == '*' }.toList()

        case.forEach { priority ->
            var tempoper = operationInput
            var temp = numberInput

            priority.forEach { o ->
                val result = arrayListOf<Long>()
                temp.forEach {
                    result.add(it)
                }
                var idx = 0
                var operIdx = 0
                while(operIdx < tempoper.size) {
                    if (tempoper[operIdx] == o) {
                        when (o) {
                            '-' -> result[idx] -= result[idx + 1]
                            '+' -> result[idx] += result[idx + 1]
                            '*' -> result[idx] *= result[idx + 1]
                        }
                        result.removeAt(idx + 1)
                    } else {
                        idx++
                    }
                    operIdx++
                }
                tempoper = tempoper.filter { it != o }
                temp = result
            }

            answer = maxOf(answer, abs(temp[0]))
        }

        return answer
    }
}
