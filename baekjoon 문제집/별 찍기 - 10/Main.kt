// n == 9 일 때까지만 되는 코드
import kotlin.math.sqrt

var n = 0
var sqrtN = 0
val space = Array(3000) { StringBuilder() }
fun main() = with(System.`in`.bufferedReader()) {
    n = readln().toInt()
    sqrtN = sqrt(n.toDouble()).toInt()

    solve(n, 0, 1, 0)
    for (i in 0 until n) {
        println(space[i])
    }
}

fun solve(n: Int, prevIdx: Int, idx: Int, depth: Int) {
    if (n == 1) {
        space[3 * ((prevIdx - 1) / 3) + (idx - 1) / 3].append(if (prevIdx != 5 && idx != 5) '*' else ' ')
        return
    }

    for (i in 1..9) {
        solve(n / 3, idx,  i, depth + 1)
    }
}
