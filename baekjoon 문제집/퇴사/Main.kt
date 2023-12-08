import java.util.StringTokenizer

var answer = 0
fun main() = with(System.`in`.bufferedReader()) {
    val N = readln().toInt()
    val schedule = Array(N + 1) {IntArray(2) {0}}


    for (i in 1..N) {
        val st = StringTokenizer(readln())
        schedule[i][0] = st.nextToken().toInt()
        schedule[i][1] = st.nextToken().toInt()
    }

    for (i in 1..N) {
        solve(schedule, i + schedule[i][0], N, schedule[i][1])
    }

    println(answer)
}

fun solve(schedule: Array<IntArray>, start: Int, limit: Int, sum: Int) {
    if (start > limit + 1) return

    if (start == limit + 1) {
        answer = maxOf(answer, sum)
        return
    }

    solve(schedule, start + schedule[start][0], limit, sum + schedule[start][1])
    solve(schedule, start + 1, limit, sum)
}
