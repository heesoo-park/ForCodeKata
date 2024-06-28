import java.io.*
import java.util.*
import kotlin.math.*

private val acc = LongArray(60)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    acc[0] = 1
    for (i in 1 until 60) {
        acc[i] = (acc[i - 1] shl 1) + (1L shl i)
    }
    
    val (a, b) = br.readLine().split(' ').map { it.toLong() }
    val result = countOne(b) - countOne(a - 1)
    
    print(result)
}

fun countOne(n: Long): Long {
    var num = n
    var cnt = (num and 1)
    val size = (log10(num.toDouble()) / log10(2.0)).toInt()
    
    for (i in size downTo 1) {
        if ((num and (1L shl i)) != 0L) {
            cnt += acc[i - 1] + (num - (1L shl i) + 1)
            num -= (1L shl i)
        }
    }
    
    return cnt
}
