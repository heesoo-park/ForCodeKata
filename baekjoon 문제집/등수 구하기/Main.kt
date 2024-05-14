import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, s, p) = br.readLine().split(' ').map { it.toInt() }
    val rankingList = if (n != 0) br.readLine().split(' ').map { it.toInt() } else emptyList()

    var rank = 1
    var pos = 0
    for (i in rankingList.indices) {
        pos++
        if (rankingList[i] > s) {
            rank++
        } else if (rankingList[i] < s) {
            break
        }
    }

    if (pos == p) {
        if (rankingList[p - 1] < s) {
            bw.write("$rank")
        } else {
            bw.write("-1")
        }
    } else {
        bw.write("$rank")
    }

    bw.flush()
    bw.close()
}
