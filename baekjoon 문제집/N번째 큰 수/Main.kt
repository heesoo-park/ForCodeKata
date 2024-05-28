import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val n = br.readLine().toInt()
    val table = Array(n) { ArrayDeque<Int>() }
    repeat(n) { it ->
        val line = br.readLine().split(' ').map { it.toInt() }
        line.forEachIndexed { index, i -> 
            table[index].add(i)
        }
    }
    
    var cnt = 0
    while (true) {
        var maxIndex = 0
        cnt++
        table.forEachIndexed { index, i ->
            if (i.last > table[maxIndex].last) {
                maxIndex = index
            }
        }
        
        if (cnt == n) {
            bw.write("${table[maxIndex].last}")
            break
        }
        
        table[maxIndex].removeLast()
    }
    
    bw.flush()
    bw.close()
}
