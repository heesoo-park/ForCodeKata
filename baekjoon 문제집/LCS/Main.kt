val dp: Array<Array<Int>> = Array(1001) { Array(1001) { 0 } }
fun main() = with(System.`in`.bufferedReader()) {
    val s1 = readln()
    val s2 = readln()
    var lcs = 0

    for (i in s2.indices) {
        for (j in s1.indices) {
            dp[i + 1][j + 1] =
                if (s1[j] == s2[i]) {
                    dp[i][j] + 1
                } else {
                    maxOf(dp[i][j + 1], dp[i + 1][j])
                }
            lcs = maxOf(lcs, dp[i + 1][j + 1])
        }
    }

    println(lcs)
}
