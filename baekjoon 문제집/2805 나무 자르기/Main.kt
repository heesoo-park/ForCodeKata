import java.io.*
import java.util.*
import kotlin.math.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val trees = br.readLine().split(' ').map { it.toInt() }
    
    var low = 0
    var high = trees.max()!!
    while (low <= high) {
        val mid = (low + high) / 2
        
        var sum: Long = 0L
        for (tree in trees) {
            if (tree > mid) sum += (tree - mid)
        }
        
        if (sum >= m) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    
    bw.write("$high")
    bw.flush()
    bw.close()
}
