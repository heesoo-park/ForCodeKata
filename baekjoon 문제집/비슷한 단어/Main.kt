import java.io.*
import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    var result = n - 1

    val firstWord = br.readLine()
    val first = firstWord.groupingBy { it }.eachCount()
    repeat(n - 1) {
        val curWord = br.readLine()
        val cur = curWord.groupingBy { it }.eachCount()

        var cnt = 0
        var isDoubled = false
        for (i in first.keys.union(cur.keys)) {
            if (cur.containsKey(i) && first.containsKey(i)) {
                val diff = abs(first[i]!! - cur[i]!!)
                cnt += diff
                if (diff >= 2) isDoubled = true
            } else if (cur.containsKey(i)) {
                cnt += cur[i]!!
            } else if (first.containsKey(i)) {
                cnt += first[i]!!
            }
        }

        if (cnt > 2) {
            result--
        } else if (cnt == 2) {
            if (isDoubled) {
                result--
            } else if (firstWord.length != curWord.length) {
                result--
            }
        }
    }

    bw.write("$result")
    bw.flush()
    bw.close()
}
