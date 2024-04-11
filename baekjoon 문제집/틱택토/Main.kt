import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val input = readln()
        if (input == "end") break

        val pieces = input.groupingBy { it }.eachCount()

        val resultX = check(input, 'X')
        val resultO = check(input, 'O')

        if (resultX && !resultO && pieces['X'] == pieces['O']?.plus(1)) {
            bw.write("valid\n")
        } else if (!resultX && resultO && pieces['X'] == pieces['O']) {
            bw.write("valid\n")
        } else if (!resultX && !resultO && pieces['X'] == 5 && pieces['O'] == 4) {
            bw.write("valid\n")
        } else {
            bw.write("invalid\n")
        }
    }

    bw.flush()
    bw.close()
}

fun check(str: String, piece: Char): Boolean {
    for (i in 0 until 3) {
        if (str[i] == piece && str[i] == str[i + 3] && str[i + 3] == str[i + 6]) return true
    }

    for (i in str.indices step 3) {
        if (str[i] == piece && str[i] == str[i + 1] && str[i + 1] == str[i + 2]) return true
    }

    if (str[0] == piece && str[0] == str[4] && str[4] == str[8]) return true

    if (str[2] == piece && str[2] == str[4] && str[4] == str[6]) return true

    return false
}
