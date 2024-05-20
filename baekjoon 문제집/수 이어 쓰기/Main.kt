import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val nums = br.readLine()
    
    var step = 1
    var numsIdx = 0
    while (true) {
        val cur = step.toString()
        for (j in cur) {
            if (j == nums[numsIdx]) {
                numsIdx++
                if (numsIdx == nums.length) break
            }
        }
        
        if (numsIdx == nums.length) {
            bw.write("$cur")
            break
        }
        
        step++
    }
    
    bw.flush()
    bw.close()
}
