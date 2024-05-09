import java.io.BufferedWriter
import java.io.OutputStreamWriter

data class BigInfo(
    val weight: Int,
    val height: Int
) {
    companion object {
        fun mappingToFormat(input: String): BigInfo {
            val splitInput = input.split(' ').map { it.toInt() }
            return BigInfo(splitInput[0], splitInput[1])
        }
    }
}

private lateinit var infoList: List<BigInfo>
private lateinit var rankList: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()

    infoList = List(n) { BigInfo.mappingToFormat(readln()) }
    rankList = IntArray(n)

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == j) continue

            if (compareBig(infoList[i], infoList[j])) {
                rankList[i]++
            }
        }
    }

    rankList.forEach {
        bw.write("${it + 1} ")
    }
    bw.flush()
    bw.close()
}

fun compareBig(p1: BigInfo, p2: BigInfo) = p1.weight < p2.weight && p1.height < p2.height
