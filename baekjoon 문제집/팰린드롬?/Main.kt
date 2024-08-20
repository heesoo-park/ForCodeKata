import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    lateinit var st: StringTokenizer
    val sb = StringBuilder()
    
    val n = readLine().toInt()
    
    val list = IntArray(n + 1)
    st = StringTokenizer(readLine())
    for (i in 1..n) {
        list[i] = st.nextToken().toInt()
    }
    
    val dp = Array(n + 1) { BooleanArray(n + 1) }
    for (i in 1..n) {
        dp[i][i] = true
        if (i != 1 && list[i - 1] == list[i]) dp[i - 1][i] = true
    }
    
    for (j in 2..n - 1) {
        for (i in 1..n) {
            if (i + j > n) break
            
            if (list[i] == list[i + j] && dp[i + 1][i + j - 1]) dp[i][i + j] = true
        }
    }
    
    var m = readLine().toInt()
    while (m-- > 0) {
        val (s, e) = readLine().split(' ').map { it.toInt() }
        sb.append(if (dp[s][e]) 1 else 0).append('\n')
    }
    
    print(sb)
}
