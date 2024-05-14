import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val table = br.readLine().split(' ').map { it.toInt() }
        val scores = IntArray(table.size)
        val cntOfMember = IntArray(201)
        val teamScores = IntArray(201)
        val excludedTeams = table.groupingBy { it }.eachCount().filter { it.value < 6 }.keys

        var score = 1
        for (i in 0 until n) {
            if (table[i] !in excludedTeams) {
                scores[i] = score
                cntOfMember[table[i]]++

                if (cntOfMember[table[i]] <= 4) teamScores[table[i]] += score
                score++
            }
        }

        var maxIndex = teamScores.indexOfFirst { it != 0 }
        for (i in 2..200) {
            if (teamScores[i] == 0) continue

            if (teamScores[maxIndex] > teamScores[i]) {
                maxIndex = i
            } else if (teamScores[maxIndex] == teamScores[i]) {
                if (scores[checkFifth(table, maxIndex)] > scores[checkFifth(table, i)]) maxIndex = i
            }
        }

        bw.write("$maxIndex\n")
    }
}

fun checkFifth(table: List<Int>, team: Int): Int {
    var cnt = 0
    for (i in table.indices) {
        if (table[i] == team) cnt++
        if (cnt == 5) return i
    }

    return 0
}
