import kotlin.math.sqrt

class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer: Int = 0
        val divisorA = calDivisor(arrayA.sorted()[0])
        val divisorB = calDivisor(arrayB.sorted()[0])

        for (divisor in divisorA) {
            val a = arrayA.filter { it % divisor != 0 }
            if (a.isNotEmpty()) continue

            val b = arrayB.filter { it % divisor == 0 }
            if (b.isNotEmpty()) continue

            answer = maxOf(answer, divisor)
        }

        for (divisor in divisorB) {
            val b = arrayB.filter { it % divisor != 0 }
            if (b.isNotEmpty()) continue

            val a = arrayA.filter { it % divisor == 0 }
            if (a.isNotEmpty()) continue

            answer = maxOf(answer, divisor)
        }

        return answer
    }

    private fun calDivisor(num: Int): List<Int> {
        val temp = mutableSetOf<Int>()
        for (i in 1..sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) {
                temp += i
                temp += (num / i)
            }
        }
        
        return temp.sortedDescending().toList()
    }
}
