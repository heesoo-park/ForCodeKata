import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.PriorityQueue

const val INF = 987654321

val cave = Array(125) { IntArray(125) { 0 } }
val calRoute = Array(125) { IntArray(125) { INF } }

val dy = intArrayOf(0, 1, 0, -1)
val dx = intArrayOf(1, 0, -1, 0)

data class Pos(
    val y: Int,
    val x: Int,
    val cost: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var cnt = 1
    while (true) {
        val n = readln().toInt()
        if (n == 0) break

        resetValue()
        for (i in 0 until n) {
            val line = readln().split(' ').map { it.toInt() }
            for (j in 0 until n) {
                cave[i][j] = line[j]
            }
        }

        bfs(n)
        bw.write("Problem ${cnt++}: ${calRoute[n - 1][n - 1]}\n")
    }

    bw.flush()
    bw.close()
}

fun resetValue() {
    for (i in 0 until 125) {
        for (j in 0 until 125) {
            calRoute[i][j] = INF
        }
    }
}

fun bfs(size: Int) {
    val q = PriorityQueue<Pos> { p1, p2 ->
        when {
            p1.cost > p2.cost -> 1
            p1.cost < p2.cost -> -1
            else -> 0
        }
    }

    q.offer(Pos(0, 0, cave[0][0]))
    calRoute[0][0] = cave[0][0]

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val newR = cur.y + dy[i]
            val newC = cur.x + dx[i]

            if (newR !in 0 until size || newC !in 0 until size) continue
            if (calRoute[newR][newC] <= calRoute[cur.y][cur.x] + cave[newR][newC]) continue

            calRoute[newR][newC] = calRoute[cur.y][cur.x] + cave[newR][newC]
            q.offer(Pos(newR, newC, calRoute[newR][newC]))
        }
    }
}

// 시간초과난 코드
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList

const val INF = 987654321

val cave = Array(125) { IntArray(125) { 0 } }
val calRoute = Array(125) { IntArray(125) { INF } }

val dy = intArrayOf(0, 1, 0, -1)
val dx = intArrayOf(1, 0, -1, 0)

data class Pos(
    val y: Int,
    val x: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var cnt = 1
    while (true) {
        val n = readln().toInt()
        if (n == 0) break

        resetValue()
        for (i in 0 until n) {
            val line = readln().split(' ').map { it.toInt() }
            for (j in 0 until n) {
                cave[i][j] = line[j]
            }
        }

        bfs(n)
        bw.write("Problem ${cnt++}: ${calRoute[n - 1][n - 1]}\n")
    }

    bw.flush()
    bw.close()
}

fun resetValue() {
    for (i in 0 until 125) {
        for (j in 0 until 125) {
            calRoute[i][j] = INF
        }
    }
}

fun bfs(size: Int) {
    val q = LinkedList<Pos>()
    q.push(Pos(0, 0))
    calRoute[0][0] = cave[0][0]

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val newR = cur.y + dy[i]
            val newC = cur.x + dx[i]

            if (newR !in 0 until size || newC !in 0 until size) continue
            if (calRoute[newR][newC] <= calRoute[cur.y][cur.x] + cave[newR][newC]) continue

            calRoute[newR][newC] = calRoute[cur.y][cur.x] + cave[newR][newC]
            q.push(Pos(newR, newC))
        }
    }
}
