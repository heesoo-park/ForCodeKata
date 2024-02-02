import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val dp = Array(201) { Array(201) { 1 } }

    for (i in 1..n) {
        for (j in 2..k) {
            dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000
        }
    }

    println(dp[n][k])
}
