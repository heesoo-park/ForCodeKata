import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val route = IntArray(100001)
private val gasStation = IntArray(100001)

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    br.readLine().split(' ').map { it.toInt() }.forEachIndexed { index, i ->
        route[index] = i
    }
    br.readLine().split(' ').map { it.toInt() }.forEachIndexed { index, i ->
        gasStation[index] = i
    }

    var minCost = Int.MAX_VALUE
    var sum: Long = 0
    for (i in 0 until n) {
        if (gasStation[i] < minCost) minCost = gasStation[i]
        sum += minCost.toLong() * route[i].toLong()
    }

    println(sum)
}
