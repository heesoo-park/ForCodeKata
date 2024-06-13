import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    val n = br.readLine().toInt()
    val numbers = br.readLine().split(' ').map { it.toInt() }
    
    val visited = BooleanArray(100001)
    
    var right = 0
    var cnt = 0L
    for (left in 0 until n) {
        while (right < n) {
            if (visited[numbers[right]]) break
            visited[numbers[right]] = true
            right++
        }
        
        cnt += (right - left)
        visited[numbers[left]] = false
    }
    
    println(cnt)
}
