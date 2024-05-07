import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val wordSet = readln().uppercase().groupingBy { it }.eachCount()

    val cnt = wordSet.maxBy { it.value }
    if (wordSet.count { it.value == cnt.value } > 1) {
        bw.write("?")
    } else {
        bw.write("${cnt.key}")
    }

    bw.flush()
    bw.close()
}
