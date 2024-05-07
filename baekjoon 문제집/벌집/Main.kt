import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val dest = readln().toInt()

    var result = 1
    var step = 6
    var range = 1

    if (dest == range) {
        bw.write("$result")
    } else {
        while (true) {
            range += step
            result++

            if (dest <= range) {
                bw.write("$result")
                break
            }

            step += 6
        }
    }

    bw.flush()
    bw.close()
}
