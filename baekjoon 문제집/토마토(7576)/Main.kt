import java.util.StringTokenizer

var m: Int = 0
var n: Int = 0
var farm = mutableListOf<MutableList<Int>>()
lateinit var visited: Array<Array<Boolean>>
val q = ArrayDeque<Pair<Int, Int>>()
val dy = listOf(0, 1, 0, -1)
val dx = listOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {

    with(StringTokenizer(readln())) {
        m = nextToken().toInt()
        n = nextToken().toInt()
    }

    repeat(n) {
        farm.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }

    visited = Array(n) { Array(m) { false } }

    if (farm.count { it.count { num -> num == 1 } == m } == n) {
        println(0)
        return
    }

    farm.forEachIndexed { row, line ->
        line.forEachIndexed { col, num ->
            if (num == 1) {
                q.add(Pair(row, col))
                visited[row][col] = true
            } else if (num == -1) {
                visited[row][col] = true
            }
        }
    }

    print(bfs())
}

fun bfs(): Int {
    var count = 0

    q.add(Pair(-1, -1))
    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        val curRow = cur.first
        val curCol = cur.second

        if (curRow == -1 && curCol == -1) {
            count++
            if (q.isNotEmpty()) q.add(Pair(-1, -1))
            continue
        }

        for (i in 0 until 4) {
            val newRow = curRow + dy[i]
            val newCol = curCol + dx[i]

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue
            if (visited[newRow][newCol]) continue

            farm[newRow][newCol] = 1
            visited[newRow][newCol] = true
            q.add(Pair(newRow, newCol))
        }
    }

    farm.forEach {
        it.forEach { num ->
            if (num == 0) return -1
        }
    }
    return count -1
}
