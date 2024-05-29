import java.io.*
import java.util.*

data class Pos(
    val row: Int,
    val col: Int,
    val cnt: Int
)

private lateinit var start: Pos

val dy = listOf(0, 1, 0, -1)
val dx = listOf(1, 0, -1, 0)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) }
    var result = Array(n) { IntArray(m) { -1 } }

    for (r in 0 until n) {
        val row = br.readLine().split(' ').map { it.toInt() }
        for (c in 0 until m) {
            map[r][c] = row[c]
            if (row[c] == 2) start = Pos(r, c, 0)
            if (row[c] == 0) result[r][c] = 0
        }
    }

    val q = ArrayDeque<Pos>()
    q.add(start)
    result[start.row][start.col] = 0
    visited[start.row][start.col] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val newR = cur.row + dy[i]
            val newC = cur.col + dx[i]

            if (newR !in 0 until n || newC !in 0 until m) continue
            if (visited[newR][newC] || map[newR][newC] == 0) continue

            result[newR][newC] = cur.cnt + 1
            visited[newR][newC] = true
            q.add(Pos(newR, newC, cur.cnt + 1))
        }
    }

    result.forEach { row ->
        row.forEach { land ->
            bw.write("$land ")
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}
