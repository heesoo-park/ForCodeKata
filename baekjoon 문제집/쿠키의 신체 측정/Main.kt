import java.io.BufferedWriter
import java.io.OutputStreamWriter

private lateinit var square: Array<CharArray>

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val size = readln().toInt()
    square = Array(size + 1) { CharArray(size + 1) }

    repeat(size) { r ->
        val line = readln()
        for (c in 1..size) {
            square[r + 1][c] = line[c - 1]
        }
    }

    val heart = findHeart(size)
    bw.write("${heart[0]} ${heart[1]}\n")

    var leftArm = 0
    for (i in heart[1] - 1 downTo 1) {
        if (square[heart[0]][i] == '*') leftArm++
        else break
    }
    bw.write("$leftArm ")

    var rightArm = 0
    for (i in heart[1] + 1..size) {
        if (square[heart[0]][i] == '*') rightArm++
        else break
    }
    bw.write("$rightArm ")

    var waist = 0
    var waistEnd = heart[0]
    for (i in heart[0] + 1..size) {
        if (square[i][heart[1]] == '*') {
            waistEnd++
            waist++
        }
        else break
    }
    bw.write("$waist ")

    var leftLeg = 0
    for (i in waistEnd + 1..size) {
        if (square[i][heart[1] - 1] == '*') leftLeg++
        else break
    }
    bw.write("$leftLeg ")

    var rightLeg = 0
    for (i in waistEnd + 1..size) {
        if (square[i][heart[1] + 1] == '*') rightLeg++
        else break
    }
    bw.write("$rightLeg\n")

    bw.flush()
    bw.close()
}

fun findHeart(size: Int): List<Int> {
    for (i in 1..size) {
        for (j in 1..size) {
            if (square[i - 1][j] == '*' && square[i][j - 1] == '*'
                && square[i + 1][j] == '*' && square[i][j + 1] == '*') {
                return listOf(i, j)
            }
        }
    }

    return listOf(size, size)
}
