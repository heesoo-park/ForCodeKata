import java.util.StringTokenizer

var m: Int = 0
var n: Int = 0
var h: Int = 0
var check: Int = 0

lateinit var box: Array<Array<Array<Int>>>
lateinit var visited: Array<Array<Array<Boolean>>>
val q = ArrayDeque<Triple<Int, Int, Int>>()

val dy = listOf(0, 1, 0, -1, 0, 0)
val dx = listOf(1, 0, -1, 0, 0, 0)
val dz = listOf(0, 0, 0, 0, 1, -1)
fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        m = this.nextToken().toInt()
        n = this.nextToken().toInt()
        h = this.nextToken().toInt()
    }

    box = Array(h) { Array(n) { Array(m) { 0 } } }
    visited = Array(h) { Array(n) { Array(m) { false } } }
    for (i in 0 until h) {
        for (j in 0 until n) {
            val st = StringTokenizer(readln())
            for (k in 0 until m) {
                box[i][j][k] = st.nextToken().toInt()
                if (box[i][j][k] == 1) {
                    q.add(Triple(i, j, k))
                    visited[i][j][k] = true
                } else if (box[i][j][k] == -1) {
                    check++
                }
            }
        }
    }

    println(bfs())
}

fun bfs(): Int {
    var count = 0

    q.add(Triple(-1, -1, -1))

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        
        if (cur.first == -1 && q.isNotEmpty()) {
            q.add(Triple(-1, -1, -1))
            count++
        }

        for (i in 0 until 6) {
            val newHeight = cur.first + dz[i]
            val newRow = cur.second + dy[i]
            val newCol = cur.third + dx[i]


            if (newHeight < 0 || newHeight >= h || newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue
            if (visited[newHeight][newRow][newCol]) continue
            if (box[newHeight][newRow][newCol] == -1) continue

            q.add(Triple(newHeight, newRow, newCol))
            visited[newHeight][newRow][newCol] = true
        }
    }

    return if (checkBox()) -1 else count
}

fun checkBox(): Boolean {
    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (!visited[i][j][k] && box[i][j][k] != -1) return true
            }
        }
    }

    return false
}
