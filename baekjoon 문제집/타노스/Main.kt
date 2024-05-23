import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val s = br.readLine()
    var cntOfZero = s.count { it == '0' } / 2
    var cntOfOne = s.count { it == '1' } / 2
    
    val result = StringBuilder()
    for (i in s) {
        if (i == '1') {
            if (cntOfOne > 0) {
                cntOfOne--
            } else {
                result.append(i)
            }
        } else {
            if (cntOfZero > 0) {
                result.append(i)
                cntOfZero--
            }
        }
    }
    
    bw.write("$result")
    bw.flush()
    bw.close()
}
