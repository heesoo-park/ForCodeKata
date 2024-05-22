import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE

private lateinit var space: Array<IntArray>
private val dp = Array(6) { Array(6) { IntArray(3) { INF }}}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    space = Array(n) { IntArray(m) }
    
    for (i in 0 until n) {
        val line = br.readLine().split(' ').map { it.toInt() }
        for (j in 0 until m) {
            space[i][j] = line[j]
        }
    }
    
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (i == 0) {
                dp[i][j][0] = space[i][j]
                dp[i][j][1] = space[i][j]
                dp[i][j][2] = space[i][j]
                continue
            }
            
            when (j) {
                0 -> {
                    dp[i][j][0] = minOf(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + space[i][j]
                    dp[i][j][1] = dp[i - 1][j][0] + space[i][j]
                }
                m - 1 -> {
                    dp[i][j][1] = dp[i - 1][j][2] + space[i][j]
                    dp[i][j][2] = minOf(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + space[i][j]
                }
                else -> {
                    dp[i][j][0] = minOf(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + space[i][j]
                    dp[i][j][1] = minOf(dp[i - 1][j][0], dp[i - 1][j][2]) + space[i][j]
                    dp[i][j][2] = minOf(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + space[i][j]
                }
            }
        }
    }
    
    var result = INF
    for (j in 0 until m) {
        for (d in 0 until 3) {
            result = minOf(result, dp[n - 1][j][d])
        }
    }
    
    bw.write("$result")
    bw.flush()
    bw.close()
}
