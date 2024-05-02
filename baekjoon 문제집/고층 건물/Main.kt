import java.io.BufferedWriter
import java.io.OutputStreamWriter

private lateinit var buildings: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()

    buildings = readln().split(' ').map { it.toInt() }.toIntArray()

    bw.write("${solve(n)}\n")
    bw.flush()
    bw.close()
}

fun solve(n : Int): Int {
    var result = 0
    for (i in 0 until n) {
        var cnt = 0
        if (i != 0) {
            var prev = 0.0
            for (j in i - 1 downTo 0) {
                prev = if (j == i - 1) {
                    cnt++
                    (buildings[i] - buildings[j]).toDouble() / (i - j).toDouble()
                } else {
                    val cur = (buildings[i] - buildings[j]).toDouble() / (i - j).toDouble()
                    if (cur < prev) cnt++

                    minOf(prev, cur)
                }
            }
        }

        if (i != n - 1) {
            var prev = 0.0
            for (j in i + 1 until n) {
                prev = if (j == i + 1) {
                    cnt++
                    (buildings[j] - buildings[i]).toDouble() / (j - i).toDouble()
                } else {
                    val cur = (buildings[j] - buildings[i]).toDouble() / (j - i).toDouble()
                    if (cur > prev) cnt++

                    maxOf(prev, cur)
                }
            }
        }

        result = maxOf(result, cnt)
    }

    return result
}
