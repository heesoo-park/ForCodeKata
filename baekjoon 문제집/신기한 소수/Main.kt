val result = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val startList = listOf(2, 3, 5, 7)
    for (i in 0..3) {
        checkPosition(n, StringBuilder().append(startList[i]))
    }

    println(result)
}

fun checkPosition(length: Int, sb: StringBuilder) {
    if (sb.length == length) {
        result.append(sb).append("\n")
        return
    }

    val canUseList = listOf(1, 3, 7, 9)
    for (i in 0..3) {
        if (checkPrimeNumber((sb.append(canUseList[i]).toString()).toInt())) {
            checkPosition(length, sb)
        }
        sb.deleteCharAt(sb.lastIndex)
    }
}

fun checkPrimeNumber(num: Int): Boolean {
    var i = 2
    while (i * i <= num) {
        if (num % i++ == 0) return false
    }
    return true
}

// 메모리 초과 4
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val maxLength = 10.0.pow(n - 1).toInt()
    var start = 2 * maxLength
    val sb = StringBuilder()

    while (start.toString().length != n + 1) {
        if(start.toString()[0] !in listOf('2', '3', '5', '7')) {
            start++
            continue
        }

        if (checkPosition(start, maxLength)) sb.append(start).append("\n")

        start++
    }

    println(sb)
}

fun checkPosition(num: Int, length: Int): Boolean {
    var divider = length / 10
    while (divider != 0) {
        val temp = (num / divider).toString()
        if (temp.last() !in listOf('1', '3', '7', '9')) return false
        if (checkPrimeNumber(num / divider).not()) return false
        divider /= 10
    }
    return true
}

fun checkPrimeNumber(num: Int): Boolean {
    var i = 2
    while (i * i <= num) {
        if (num % i++ == 0) return false
    }
    return true
}

// 메모리 초과 3
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val maxLength = 10.0.pow(n - 1).toInt()
    var start = 2 * maxLength
    val sb = StringBuilder()

    while (start.toString().length != n + 1) {
        if(start.toString()[0] !in listOf('2', '3', '5', '7')) {
            start++
            continue
        }

        if (checkPosition(start, maxLength)) sb.append(start).append("\n")

        start++
    }

    println(sb)
}

fun checkPosition(num: Int, length: Int): Boolean {
    var divider = length
    while (divider != 0) {

        if (checkPrimeNumber(num / divider).not()) return false

        divider /= 10
    }
    return true
}

fun checkPrimeNumber(num: Int): Boolean {
    var i = 2
    while (i * i <= num) {
        if (num % i++ == 0) return false
    }
    return true
}

// 메모리 초과 2
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val maxLength = 10.0.pow(n - 1).toInt()
    var start = 2 * maxLength
    val sb = StringBuilder()

    while (start.toString().length != n + 1) {
        if (checkPosition(start, maxLength)) sb.append(start).append("\n")
        start++
    }

    println(sb)
}

fun checkPosition(num: Int, length: Int): Boolean {
    var divider = length
    while (divider != 0) {

        if (checkPrimeNumber(num / divider).not()) return false

        divider /= 10
    }
    return true
}

fun checkPrimeNumber(num: Int): Boolean {
    var i = 2
    while (i * i <= num) {
        if (num % i++ == 0) return false
    }
    return true
}

// 메모리 초과 1
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    var start = 2 * 10.0.pow(n - 1).toInt()
    val sb = StringBuilder()

    while (start.toString().length != 5) {
        if (checkPosition(start, n)) sb.append(start).append("\n")
        start++
    }

    println(sb)
}

fun checkPosition(num: Int, length: Int): Boolean {
    var divider = 10.0.pow(length - 1).toInt()
    while (divider != 0) {

        if (checkPrimeNumber(num / divider).not()) return false

        divider /= 10
    }
    return true
}

fun checkPrimeNumber(num: Int): Boolean {
    var i = 2
    while (i * i <= num) {
        if (num % i++ == 0) return false
    }
    return true
}
