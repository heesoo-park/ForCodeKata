import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, d, k, c) = br.readLine().split(' ').map { it.toInt() }
    
    val sushiBelt = List<Int>(n) { br.readLine().toInt() }
    val sushiTypes = IntArray(d + 1)
    var max = 0
    var cnt = 0
    
    for (i in 0 until k) {
        if (sushiTypes[sushiBelt[i % n]] == 0) cnt++
        sushiTypes[sushiBelt[i % n]]++
    }
    max = if (sushiTypes[c] == 0) maxOf(max, cnt + 1) else maxOf(max, cnt)
    
    for (i in 1 until n) {
        if (sushiTypes[sushiBelt[(i + k - 1) % n]] == 0) cnt++
        sushiTypes[sushiBelt[(i + k - 1) % n]]++ 
        
        sushiTypes[sushiBelt[(i - 1) % n]]--
        if (sushiTypes[sushiBelt[(i - 1) % n]] == 0) cnt--
        
        
        max = if (sushiTypes[c] == 0) maxOf(max, cnt + 1) else maxOf(max, cnt)
    }
    
    bw.write("$max")
    bw.flush()
    bw.close()
}
