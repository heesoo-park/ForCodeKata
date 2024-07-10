import kotlin.math.floor
import kotlin.math.sqrt

class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        var num2: Long = 0
        for (i in 1 until r2) {
            num2 += floor(sqrt((r2.toLong() * r2 - i.toLong() * i).toDouble())).toLong()
        }
        answer += r2 * 4 + 1 + num2 * 4

        var num1: Long = 0
        for (i in 1 until r1) {
            val count = sqrt((r1.toLong() * r1 - i.toLong() * i).toDouble())

            num1 += if (floor(count) == count) {
                floor(count).toLong() - 1
            } else {
                floor(count).toLong()
            }

        }
        answer -= (r1 - 1) * 4 + 1 + num1 * 4

        return answer
    }
}

// 60퍼 통과
import kotlin.math.floor
import kotlin.math.sqrt

class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        var num2: Long = 0
        for (i in 1 until r2) {
            num2 += floor(sqrt((r2.toLong() * r2 - i * i).toDouble())).toLong()
        }
        answer += r2 * 4 + 1 + num2 * 4

        var num1: Long = 0
        for (i in 1 until r1) {
            val count = sqrt((r1.toLong() * r1 - i * i).toDouble())

            num1 += if (floor(count) == count) {
                floor(count).toLong() - 1
            } else {
                floor(count).toLong()
            }

        }
        answer -= (r1 - 1) * 4 + 1 + num1 * 4

        return answer
    }
}

// 20퍼 통과
import kotlin.math.floor
import kotlin.math.sqrt

class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        var num2 = 0
        for (i in 1 until r2) {
            num2 += floor(sqrt((r2 * r2 - i * i).toDouble())).toInt()
        }
        answer += r2 * 4 + 1 + num2 * 4

        var num1 = 0
        for (i in 1 until r1) {
            num1 += floor(sqrt((r1 * r1 - i * i).toDouble())).toInt()
        }
        answer -= r1 * 4 + 1 + num1 * 4

        answer += 4
        return answer
    }
}
