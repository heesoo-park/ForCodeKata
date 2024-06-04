import java.io.*
import java.util.*
import kotlin.math.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val n = br.readLine().toInt()
    val solutions = br.readLine().split(' ').map { it.toInt() }
    
    var min = -1
    var max = -1
    var sum = 2000000000
    
    var left = 0
    var right = n - 1
    while (left < right) {
        if (abs(solutions[right] + solutions[left]) < abs(sum)) {
            min = solutions[left]
            max = solutions[right]
            sum = max + min   
        }
        
        if (solutions[right] + solutions[left] < 0) left++ else right--
    }
    
    bw.write("$min $max")
    bw.flush()
    bw.close()
}
