import java.util.StringTokenizer
import kotlin.math.abs

var answer = Int.MAX_VALUE
fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val synergy = Array(n + 1) {IntArray(n + 1) {0}}
    val visited = BooleanArray(n + 1) {false}

    for (i in 1..n) {
        val st = StringTokenizer(readln())
        for (j in 1..n) {
            synergy[i][j] = st.nextToken().toInt()
        }
    }

    solve(synergy, visited, 1, n / 2, 0)

    println(answer)
}

fun solve(synergy: Array<IntArray>, visited: BooleanArray, start: Int, limit: Int, cnt: Int) {
    if (cnt == limit) {
        var startTeam = 0
        var linkTeam = 0

        for (i in 1 until limit * 2) {
            for (j in i + 1..limit * 2) {
                if (visited[i] && visited[j]) {
                    startTeam += synergy[i][j]
                    startTeam += synergy[j][i]
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += synergy[i][j]
                    linkTeam += synergy[j][i]
                }
            }
        }

        val diff = abs(startTeam - linkTeam)
        answer = minOf(answer, diff)
        return
    }

    for (i in start..limit * 2) {
        visited[i] = true
        solve(synergy, visited, i + 1, limit, cnt + 1)
        visited[i] = false
    }
}
