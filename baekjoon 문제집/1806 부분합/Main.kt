import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, s) = br.readLine().split(' ').map { it.toInt() }
    val nums = br.readLine().split(' ').map { it.toLong() }
    val accNums = LongArray(n + 1)
    
    for (i in 0 until n) {
        if (i == 0) {
            accNums[i + 1] = nums[i]
            continue
        }
        
        accNums[i + 1] = accNums[i] + nums[i]
    }
    
    var start = 0
    var end = 0
    var length = 0
    while (true) {
        var sum = accNums[end] - accNums[start]
        
        if (sum < s) {
            end++
        } else {
            if (length == 0 || length > (end - start)) {
                length = end - start
            }
            
            start++
        }
        
        if (end > n) break
    }
    
    bw.write("$length")
    bw.flush()
    bw.close()
}
