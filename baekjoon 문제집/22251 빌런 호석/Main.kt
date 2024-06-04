import java.io.*
import java.util.*
import kotlin.math.*

private val numbers = listOf(0b1110111, 0b0010010, 0b1011101, 0b1011011, 0b0111010, 0b1101011, 0b1101111, 0b1010010, 0b1111111, 0b1111011)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, k, p, x) = br.readLine().split(' ').map { it.toInt() }
    var result = 0
    
    for (floor in 1..n) {
        if (floor == x) continue
        
        var cnt = 0
        var cur = x
        var target = floor
        for (i in 0 until k) {
            val temp = Integer.toBinaryString(numbers[cur % 10] xor numbers[target % 10])
            
            cnt += temp.count { it == '1' }
            cur /= 10
            target /= 10
        }
        
        if (cnt <= p) result++
    }
    
    bw.write("$result")
    bw.flush()
    bw.close()
}
