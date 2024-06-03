import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val s = br.readLine()
    val aLen = s.count { it == 'a' }
    var min = 1000
    
    for (i in 0 until s.length) {
        var cnt = 0
        for (j in i until i + aLen) {
            if (s[j % s.length] == 'b') cnt++
        }
        
        min = minOf(min, cnt)
    }
    
    bw.write("$min")
    bw.flush()
    bw.close()
}
