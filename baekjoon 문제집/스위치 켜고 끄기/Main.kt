import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private lateinit var states: Array<Boolean>

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    states = (listOf(false) + br.readLine().split(' ').map { it == "1" }).toTypedArray()

    val students = br.readLine().toInt()
    repeat(students) {
        val (gender, num) = br.readLine().split(' ').map { it.toInt() }
        changeSwitch(n, gender, num)
    }

    for (i in 1..states.lastIndex) {
        if (states[i]) {
            bw.write("1 ")
        } else {
            bw.write("0 ")
        }

        if (i % 20 == 0) {
            bw.write("\n")
        }
    }

    bw.flush()
    bw.close()
}

fun changeSwitch(size: Int, gender: Int, num: Int) {
    if (gender == 1) {
        for (i in num..size step num) {
            states[i] = !states[i]
        }
    } else {
        var range = 0
        for (i in 1..size / 2) {
            if (num - i < 1 || num + i > size) break

            if (states[num - i] == states[num + i]) range++
            else break
        }

        for (i in num - range..num + range) {
            states[i] = !states[i]
        }
    }
}
