import java.util.ArrayDeque
import java.util.StringTokenizer

var n: Int = 0
var k: Int = 0
var dp = Array(100001) { Int.MAX_VALUE }

fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }

    bfs()
}

fun bfs() {
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(Pair(n, 0))
    dp[n] = 0

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        if (cur.first - 1 >= 0 && dp[cur.first - 1] > cur.second) {
            dp[cur.first - 1] = cur.second + 1
            q.add(Pair(cur.first - 1, cur.second + 1))
        }

        if (cur.first + 1 <= 100000 && dp[cur.first + 1] > cur.second) {
            dp[cur.first + 1] = cur.second + 1
            q.add(Pair(cur.first + 1, cur.second + 1))
        }

        if (cur.first * 2 <= 100000 && dp[cur.first * 2] > cur.second) {
            dp[cur.first * 2] = cur.second
            q.add(Pair(cur.first * 2, cur.second))
        }
    }

    println(dp[k])
}
