var n: Int = 0
lateinit var painting: Array<CharArray>
val dy = listOf(0, 1, 0, -1)
val dx = listOf(1, 0, -1, 0)
fun main() = with(System.`in`.bufferedReader()) {
    n = readln().toInt()
    painting = Array(n) { charArrayOf() }

    for (i in 0 until n) {
        painting[i] = readln().toCharArray()
    }

    print("${getArea(1)} ${getArea(2)}" )
}

fun getArea(type: Int): Int {
    val visited = Array(n) { Array(n) { false } }
    var count = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j].not()) {
                bfs(visited, i, j, type)
                count++
            }
        }
    }

    return count
}

fun bfs(visited: Array<Array<Boolean>>, r: Int, c: Int, type: Int) {
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(Pair(r, c))
    visited[r][c] = true

    val color = painting[r][c]

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0 until 4) {
            val newRow = cur.first + dy[i]
            val newCol = cur.second + dx[i]

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) continue
            if (visited[newRow][newCol]) continue
            if (type == 1) {
                if (painting[newRow][newCol] != color) continue
            } else {
                if (color == 'R' && painting[newRow][newCol] == 'B' ||
                    color == 'G' && painting[newRow][newCol] == 'B' ||
                    color == 'B' && painting[newRow][newCol] != color) continue
            }

            q.add(Pair(newRow, newCol))
            visited[newRow][newCol] = true
        }
    }
}
