import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val pos = br.readLine().split(' ').map { it.toInt() }

    var low = 1
    var high = 100000
    var result = 100000
    while (low <= high) {
        val mid = (low + high) / 2

        var prev = 0
        for (i in 0 until m) {
            if (pos[i] - mid <= prev) {
                prev = pos[i] + mid
            } else {
                break
            }
        }

        if (n - prev <= 0) {
            result = minOf(result, mid)
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    bw.write("$result")
    bw.flush()
    bw.close()
}


// 시간초과난 코드
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val pos = br.readLine().split(' ').map { it.toInt() }

    var low = 1
    var high = 100000
    var result = 100000
    while (low <= high) {
        val mid = (low + high) / 2
        val line = BooleanArray(n + 1)

        for (i in 0 until m) {
            for (j in pos[i] - mid..pos[i] + mid) {
                if (j < 0 || j > n) continue

                line[j] = true
            }
        }

        if (line.all { it }) {
            result = minOf(result, mid)
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    bw.write("$result")
    bw.flush()
    bw.close()
}
