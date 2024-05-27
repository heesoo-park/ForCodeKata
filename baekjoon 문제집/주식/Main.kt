import java.io.*
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))

fun main(args: Array<String>) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = br.readLine().toInt()
    repeat(t) {
        bw.write("${getMaxBenefit()}\n")
    }

    bw.flush()
    bw.close()
}

fun getMaxBenefit(): Long {
    val n = br.readLine().toInt()
    val stocks = br.readLine().split(' ').map { it.toInt() }
    var result: Long = 0

    var max = stocks[n - 1]
    for (i in n - 2 downTo 0) {
        if (max > stocks[i]) {
            result += (max - stocks[i])
        } else {
            max = stocks[i]
        }
    }

    return result
}

// 시간초과 코드
import java.io.*
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))

fun main(args: Array<String>) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = br.readLine().toInt()
    repeat(t) {
        bw.write("${getMaxBenefit()}\n")
    }

    bw.flush()
    bw.close()
}

fun getMaxBenefit(): Long {
    val n = br.readLine().toInt()
    val stocks = br.readLine().split(' ').map { it.toInt() }
    var result: Long = 0

    var max = stocks.max() ?: 0
    val infos = mutableListOf<Int>()
    for (i in stocks.indices) {
        if (stocks[i] < max) {
            infos.add(stocks[i])
        } else {
            if (infos.isNotEmpty()) {
                result += infos.map { max - it }.sum()
                infos.clear()
            }
            
            if (i != stocks.lastIndex) max = stocks.slice(i + 1..stocks.lastIndex).max() ?: 0
        }
    }

    return result
}
