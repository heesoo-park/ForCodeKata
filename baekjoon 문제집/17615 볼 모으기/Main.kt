import java.io.*
import java.util.*

private const val left = 0
private const val right = 1

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val n = br.readLine().toInt()
    val balls = br.readLine()
    
    val redCount = balls.count { it == 'R' }
    val blueCount = n - redCount
    var result = minOf(redCount, blueCount)
    
    result = minOf(result, calCount(n, balls, 0))
    result = minOf(result, calCount(n, balls, 1))
    
    bw.write("$result")
    bw.flush()
    bw.close()
}

fun calCount(n: Int, balls: String, dir: Int): Int {
    var isDivided = false
    var cnt = 0
    
    if (dir == right) {
        val c = balls[n - 1]
        for (i in n - 1 downTo 0) {
            if (balls[i] != c) isDivided = true
            if (isDivided && balls[i] == c) cnt++
        }
    } else {
        val c = balls[0]
        for (i in 0 until n) {
            if (balls[i] != c) isDivided = true
            if (isDivided && balls[i] == c) cnt++
        }
    }
    
    return cnt
}
