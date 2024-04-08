import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList
import kotlin.math.abs

var info = Info.init()

val land = Array(50) { Array(50) { 0 } }
val calculation = Array(50) { Array(50) { 0 } }
val visited = Array(50) { Array(50) { false } }

val dy = listOf(0, 1, 0, -1)
val dx = listOf(1, 0, -1, 0)

var isFinish = false

data class Pos(
    val row: Int,
    val col: Int
)

data class Info(
    val n: Int,
    val l: Int,
    val r: Int
) {
    companion object {
        fun init() = Info(0, 0, 0)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    readln().split(' ').map { it.toInt() }.let {
        info = Info(it[0], it[1], it[2])
    }

    for (i in 0 until info.n) {
        val row = readln().split(' ').map { it.toInt() }
        for (j in 0 until info.n) {
            land[i][j] = row[j]
        }
    }

    var cnt = 0
    while(isFinish.not()) {
        for (i in 0 until info.n) {
            for (j in 0 until info.n) {
                if (visited[i][j].not()) bfs(i, j)
            }
        }

        for (i in 0 until info.n) {
            for (j in 0 until info.n) {
                land[i][j] = calculation[i][j]
                visited[i][j] = false
            }
        }

        if (isFinish.not()) {
            bw.write("$cnt\n")
            break
        } else {
            isFinish = false
        }

        cnt++
    }

    bw.flush()
    bw.close()
}

fun bfs(r: Int, c: Int) {
    val q = LinkedList<Pos>()
    val union = mutableListOf<Pos>()
    var sum = 0

    q.add(Pos(r, c))
    visited[r][c] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()
        sum += land[cur.row][cur.col]
        union.add(cur)

        for (i in 0 until 4) {
            val newR = cur.row + dy[i]
            val newC = cur.col + dx[i]

            if (newR !in 0 until info.n || newC !in 0 until info.n) continue
            if (visited[newR][newC]) continue

            val diff = abs(land[newR][newC] - land[cur.row][cur.col])
            if (diff >= info.l && diff <= info.r) {
                visited[newR][newC] = true
                q.add(Pos(newR, newC))
            }
        }
    }

    if (union.size > 1) isFinish = true

    val avg = sum / union.size
    for (i in union) {
        calculation[i.row][i.col] = avg
    }
}
