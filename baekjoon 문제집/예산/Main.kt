import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val regions = br.readLine().split(' ').map { it.toInt() }
    val budget = br.readLine().toInt()

    if (regions.sum() < budget) {
        bw.write("${regions.max()}")
    } else {
        var low = 1
        var high = regions.max()
        var prevSum = 0
        var upperLimit = budget

        while (low <= high) {
            val mid = (low + high) / 2
            var sum = 0

            for (i in 0 until n) {
                sum += if (regions[i] > mid) mid else regions[i]
            }

            if (sum > budget) {
                high = mid - 1
            } else {
                if (abs(prevSum - budget) > abs(sum - budget)) upperLimit = mid
                low = mid + 1
            }

            prevSum = sum
        }

        bw.write("$upperLimit")
    }

    bw.flush()
    bw.close()
}
