import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val vowel = listOf('a', 'e', 'i', 'o', 'u')

    while (true) {
        val input = readln()
        if (input == "end") break

        var cntOfVowel = 0
        var isFinish = false
        for (i in input.indices) {
            if (input[i] in vowel) cntOfVowel += 1

            if (i > 1) {
                if (input[i] in vowel && input[i - 1] in vowel && input[i - 2] in vowel ||
                    input[i] !in vowel && input[i - 1] !in vowel && input[i - 2] !in vowel) {
                    bw.write("<${input}> is not acceptable.\n")
                    isFinish = true
                    break
                }
            }

            if (i > 0 && input[i] == input[i - 1]) {
                if (input[i] != 'e' && input[i] != 'o') {
                    bw.write("<${input}> is not acceptable.\n")
                    isFinish = true
                    break
                }
            }
        }

        if (cntOfVowel == 0 && !isFinish) {
            bw.write("<${input}> is not acceptable.\n")
            isFinish = true
        }

        if (!isFinish) bw.write("<${input}> is acceptable.\n")
    }

    bw.flush()
    bw.close()
}
