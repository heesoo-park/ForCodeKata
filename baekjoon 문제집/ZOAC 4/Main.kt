import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (h, w, n, m) = readln().split(' ').map { it.toInt() }

    val col = if (h % (1 + n) != 0) (h / (1 + n)) + 1 else h / (1 + n)
    val row = if (w % (1 + m) != 0) (w / (1 + m)) + 1 else w / (1 + m)

    bw.write("${col * row}")
    bw.flush()
    bw.close()
}
