import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>() { a, b ->
        a.compareTo(b)    
    }
    
    repeat(n) {
        val num = br.readLine().toInt()
        if (num == 0) {
            if (pq.isNotEmpty()) {
                bw.write("${pq.poll()}\n")
            } else {
                bw.write("0\n")
            }
        } else {
            pq.offer(num)
        }
    }
    
    bw.flush()
    bw.close()
}
