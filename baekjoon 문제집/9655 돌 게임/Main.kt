import java.io.BufferedWriter
import java.io.OutputStreamWriter

/** n개 있을 때 마지막 돌을 가져갈 때까지의 횟수를 저장하는 dp배열 */
val dp = IntArray(1001)

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()

    dp[1] = 1
    dp[2] = 2
    dp[3] = 1

    for (i in 4..n) {
        dp[i] = minOf(dp[i - 1], dp[i - 3]) + 1
    }

    bw.write(checkWinner(dp[n]))
    bw.flush()
    bw.close()
}

fun checkWinner(cnt: Int): String {
    return if (cnt % 2 == 0) {
        "CY"
    } else {
        "SK"
    }
}
