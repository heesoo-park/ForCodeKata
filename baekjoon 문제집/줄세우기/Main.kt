import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val p = readln().toInt()

    repeat(p) {
        var result = 0
        val case = readln().split(' ').map { it.toInt() }.toMutableList()
        for (i in 2 until case.size) {
            for (j in 1 until i) {
                if (case[j] > case[i]) {
                    result += (i - j)
                    case.add(j, case.removeAt(i))
                    break
                }
            }
        }

        bw.write("${it + 1} $result\n")
    }

    bw.flush()
    bw.close()
}
