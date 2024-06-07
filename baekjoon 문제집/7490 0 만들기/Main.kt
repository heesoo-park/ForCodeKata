import java.io.*
import java.util.*

private val oper = listOf(" ", "+", "-")
private val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    repeat(t) {
        val max = br.readLine().toInt()
        makeZero(1, max, "1")
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

fun makeZero(start: Int, size: Int, exp: String) {
    if (start == size) {
        val sum = calSum(exp)
        if (sum == 0) bw.write("$exp\n")
        return
    }

    for (i in oper) {
        makeZero(start + 1, size, exp + i + (start + 1))
    }
}

fun calSum(exp: String): Int {
    val regex = " ".toRegex()
    var temp = regex.replace(exp, "")
    var sum = 0
    var cur = 0
    var curOper = '+'
    for (i in temp) {
        if (i != '+' && i != '-') {
            cur = cur * 10 + (i - '0')
        } else {
            if (curOper == '+') {
                sum += cur
            } else {
                sum -= cur
            }

            curOper = i
            cur = 0
        }
    }

    if (curOper == '+') {
        sum += cur
    } else {
        sum -= cur
    }
    
    return sum
}
