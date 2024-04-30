import java.io.BufferedWriter
import java.io.OutputStreamWriter

val dp = Array(201) { 0 }

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()

    var max = 0
    val line = Array(n) { readln().toInt() }
    for (i in 0 until n) {
        dp[i] = 1
        for (j in 0..i) {
            if (line[j] < line[i] && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1
            }
        }

        max = maxOf(max, dp[i])
    }

    bw.write("${n - max}")
    bw.flush()
    bw.close()
}
