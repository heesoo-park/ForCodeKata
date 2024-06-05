import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val counters = List<Long>(n) { br.readLine().toLong() }
    
    var low: Long = 1
    var high: Long = m.toLong() * counters.max()!!
    var result: Long = 0
    while (low <= high) {
        val mid: Long = (low + high) / 2
        
        var sum: Long = 0L
        for (counter in counters) {
            sum += (mid / counter)
            if (sum > m) break
        }
        
        if (sum >= m) {
            if (result > mid || result == 0L) result = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    
    bw.write("$result")
    bw.flush()
    bw.close()
}
