import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map { it.toInt() }.sorted()
    
    var result = 0
    for (i in 0 until n) {
        var left = 0
        var right = n - 1
        while (left < right) {
            if (left == i) left++ 
            if (right == i) right--
            
            if (left >= right) break
            
            if (list[left] + list[right] > list[i]) {
                right--
            } else if (list[left] + list[right] < list[i]) {
                left++
            } else {
                result++
                break
            }
        }
    }
    
    bw.write("$result")
    bw.flush()
    bw.close()
}
