import java.io.BufferedWriter
import java.io.OutputStreamWriter

data class MedalsOfCountry(
    val country: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int
) {
    companion object {
        fun mappingToFormat(input: String): MedalsOfCountry {
            val splitInput = input.split(' ').map { it.toInt() }
            return MedalsOfCountry(splitInput[0], splitInput[1], splitInput[2], splitInput[3])
        }
    }
}

private val infoList = mutableListOf<MedalsOfCountry>()

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, k) = readln().split(' ').map { it.toInt() }

    repeat(n) {
        infoList.add(MedalsOfCountry.mappingToFormat(readln()))
    }

    infoList.sortWith(compareBy<MedalsOfCountry> { -it.gold }.thenBy { -it.silver }
        .thenBy { -it.bronze })

    var rank = 0
    var pass = 0
    for (i in 0 until infoList.size) {
        if (i > 0) {
            if (!compareMedals(infoList[i], infoList[i - 1])) {
                rank++
                rank += pass
                pass = 0
            } else {
                pass++
            }
        } else {
            rank++
        }

        if (infoList[i].country == k) {
            break
        }
    }

    bw.write("$rank")
    bw.flush()
    bw.close()
}

fun compareMedals(c1: MedalsOfCountry, c2: MedalsOfCountry) =
    c1.gold == c2.gold && c1.silver == c2.silver && c1.bronze == c2.bronze
