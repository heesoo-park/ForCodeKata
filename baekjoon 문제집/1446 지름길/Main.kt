import java.io.*
import java.util.*

data class Info(
    val start: Int,
    val len: Int
)

private val result = IntArray(10001)
private val shortCuts = Array(10001) { mutableListOf<Info>() }

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, d) = br.readLine().split(' ').map { it.toInt() }
    repeat(n) {
        val shortCut = br.readLine().split(' ').map { it.toInt() }
        if (shortCut.any { it > d }.not()) shortCuts[shortCut[1]].add(Info(shortCut[0], shortCut[2]))
    }
    
    for (i in 1..d) {
        result[i] = result[i - 1] + 1
        for (j in shortCuts[i]) {
            result[i] = minOf(result[i], result[j.start] + j.len)
        }
    }
    
    bw.write("${result[d]}")
    bw.flush()
    bw.close()
}
