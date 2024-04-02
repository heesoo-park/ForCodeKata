fun main() = with(System.`in`.bufferedReader()) {
    val t = readln().toInt()

    val dp = Array(10001) { Array(4) { 0 } }
    dp[1][1] = 1
    dp[2][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 1
    dp[3][3] = 1

    for (i in 4..10000) {
        dp[i][1] = dp[i - 1][1]
        dp[i][2] = dp[i - 2][1] + dp[i - 2][2]
        dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]
    }

    repeat(t) {
        val n = readln().toInt()
        println(dp[n][1] + dp[n][2] + dp[n][3])
    }
}
