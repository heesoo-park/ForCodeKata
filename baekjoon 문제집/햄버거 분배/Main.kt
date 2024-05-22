import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val table = br.readLine()
    val visited = BooleanArray(n) { false }
    
    var result = 0
    for (i in 0 until n) {
        if (table[i] != 'P') continue
        
        for (j in i - k..i + k) {
            if (j !in 0 until n || j == i) continue
            
            if (table[j] == 'H' && !visited[j]) {
                visited[j] = true
                result++
                break
            }
        }
    }
    
    bw.write("$result")
    bw.flush()
    bw.close()
}
