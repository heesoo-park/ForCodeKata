import java.io.BufferedWriter
import java.io.OutputStreamWriter

val houses = mutableListOf<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var result = 0

    val (n, c) = readln().split(' ').map { it.toInt() }
    repeat(n) {
        houses.add(readln().toInt())
    }

    houses.sort()

    var low = 1
    var high = houses[n - 1] - houses[0]
    while (low <= high) {
        val mid = (low + high) / 2

        var cnt = 1
        var prev = houses[0]
        for (i in 1 until n) {
            if (houses[i] - prev >= mid) {
                cnt++
                prev = houses[i]
            }
        }

        if (cnt >= c) {
            result = maxOf(result, mid)
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    bw.write("$result\n")
    bw.flush()
    bw.close()
}
