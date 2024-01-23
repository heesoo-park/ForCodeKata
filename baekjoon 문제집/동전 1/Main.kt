import java.util.StringTokenizer

var tokenList = mutableListOf<Int>()
var dp = Array(10001) { 0 }
fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    for (i in 0 until n) {
        tokenList.add(readln().toInt())
    }

    solve(n, k)

    println(dp[k])
}

fun solve(case: Int, value: Int) {
    dp[0] = 1
    for (i in 0 until case) {
        for (j in tokenList[i]..value) {
            dp[j] += dp[j - tokenList[i]]
        }
    }
}
