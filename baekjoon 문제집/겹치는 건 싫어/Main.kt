import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val nums = br.readLine().split(' ').map { it.toInt() }
    val checked = IntArray(100001)

    var front = 0
    var end = 0
    var maxLen = 0
    while (front < n) {
        if (checked[nums[front]] < k) {
            checked[nums[front]]++
            front++
        } else {
            checked[nums[end]]--
            end++
        }

        maxLen = maxOf(maxLen, front - end)
    }

    bw.write("$maxLen")
    bw.flush()
    bw.close()
}
