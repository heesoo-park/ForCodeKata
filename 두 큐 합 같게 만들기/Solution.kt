class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0
        val q1 = ArrayDeque<Int>()
        var q1Sum: Long = 0
        val q2 = ArrayDeque<Int>()
        var q2Sum: Long = 0

        queue1.forEach {
            q1.add(it)
            q1Sum += it
        }
        queue2.forEach {
            q2.add(it)
            q2Sum += it
        }

        while (answer != (q1.size + q2.size) * 2) {
            if (q1Sum > q2Sum) {
                val r = q1.removeFirst()
                q1Sum -= r
                q2Sum += r
                q2.add(r)
                answer++
            } else if (q1Sum < q2Sum) {
                val r = q2.removeFirst()
                q2Sum -= r
                q1Sum += r
                q1.add(r)
                answer++
            } else {
                break
            }
        }

        return if (answer == (q1.size + q2.size) * 2) -1 else answer
    }
}

// 3개 틀린 코드(자료형)
class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0
        val q1 = ArrayDeque<Int>()
        var q1Sum = 0
        val q2 = ArrayDeque<Int>()
        var q2Sum = 0

        queue1.forEach {
            q1.add(it)
            q1Sum += it
        }
        queue2.forEach {
            q2.add(it)
            q2Sum += it
        }

        while (answer != (q1.size + q2.size) * 2) {
            if (q1Sum > q2Sum) {
                val r = q1.removeFirst()
                q1Sum -= r
                q2Sum += r
                q2.add(r)
                answer++
            } else if (q1Sum < q2Sum) {
                val r = q2.removeFirst()
                q2Sum -= r
                q1Sum += r
                q1.add(r)
                answer++
            } else {
                break
            }
        }

        return if (answer == (q1.size + q2.size) * 2) -1 else answer
    }
}

// 4개 틀린 코드(반복문 범위, 자료형)
class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0
        val q1 = ArrayDeque<Int>()
        var q1Sum = 0
        val q2 = ArrayDeque<Int>()
        var q2Sum = 0

        queue1.forEach {
            q1.add(it)
            q1Sum += it
        }
        queue2.forEach {
            q2.add(it)
            q2Sum += it
        }

        while (answer != q1.size + q2.size) {
            if (q1Sum > q2Sum) {
                val r = q1.removeFirst()
                q1Sum -= r
                q2Sum += r
                q2.add(r)
                answer++
            } else if (q1Sum < q2Sum) {
                val r = q2.removeFirst()
                q2Sum -= r
                q1Sum += r
                q1.add(r)
                answer++
            } else {
                break
            }
        }

        return if (answer == q1.size + q2.size) -1 else answer
    }
}
