// 통과한 코드
// 우선순위큐 두 개(오름차순, 내림차순)를 쓰게 됐다.
// println을 너무 써서 시간초과가 나더라
// StringBuilder로 바꿨다.
import java.util.Collections
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val pqMin = PriorityQueue<Int>()
    val pqMax = PriorityQueue<Int>(Collections.reverseOrder())
    val answer = StringBuilder()
    var mid = 0

    for (i in 1..n) {
        with(readln().toInt()) {
            if (i == 1) {
                mid = this
                answer.append("$mid \n")
            } else {
                if (mid > this) {
                    pqMax.offer(this)
                } else {
                    pqMin.offer(this)
                }

                if (i % 2 == 0) {
                    if (pqMax.size > pqMin.size) {
                        answer.append("${minOf(pqMax.peek()!!, mid)} \n")
                    } else {
                        answer.append("${minOf(pqMin.peek()!!, mid)} \n")
                    }
                } else {
                    if (pqMax.size > pqMin.size) {
                        pqMin.offer(mid)
                    } else {
                        pqMax.offer(mid)
                    }

                    if (pqMax.size > pqMin.size) {
                        pqMax.poll()?.let { mid = it }
                    } else {
                        pqMin.poll()?.let { mid = it }
                    }
                    answer.append("$mid \n")
                }
            }
        }
    }

    println(answer)
}

// 메모리초과난 코드
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val pq = PriorityQueue<Int>()
    val temp = ArrayDeque<Int>()

    for (i in 1..n) {
        with(readln().toInt()) {
            pq.offer(this)
        }

        if (pq.size % 2 == 0) {
            for (j in 0..pq.size / 2) {
                pq.poll()?.let { temp.add(it) }
            }
            println(minOf(temp.last() , temp[temp.size - 2]) )
        } else {
            for (j in 0 until pq.size / 2 + 1) {
                pq.poll()?.let { temp.add(it) }
            }
            println(temp.last())
        }

        temp.map { pq.offer(it) }
    }
}
