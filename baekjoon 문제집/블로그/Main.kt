import java.io.*
import java.util.*

private lateinit var accNumList: Array<Long>
private lateinit var periodNumList: Array<Long>

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (x, n) = br.readLine().split(' ').map { it.toInt() }
    val visitedNum = br.readLine().split(' ').map { it.toLong()}
    accNumList = Array<Long>(x + 1) { 0L }
    periodNumList = Array<Long>(x - n + 1) { 0L }
    
    accNumList[1] = visitedNum[0]
    for (i in 1 .. visitedNum.lastIndex) {
        accNumList[i + 1] = accNumList[i] + visitedNum[i]
    }
    
    for (i in 0 .. x - n) {
        periodNumList[i] = accNumList[i + n] - accNumList[i]
    }
    
    val maxNum = periodNumList.max()
    if (maxNum == 0L) {
        bw.write("SAD\n")
    } else {
        bw.write("$maxNum\n")
        bw.write("${periodNumList.count { it == maxNum }}")
    }
    
    bw.flush()
    bw.close()
}
