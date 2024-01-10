import java.util.StringTokenizer

var n: Int = 0
var m: Int = 0
val numList: MutableList<Boolean> = MutableList(10) { true }
fun main() = with(System.`in`.bufferedReader()) {
    var result: Int = 0

    n = readln().toInt()
    m = readln().toInt()

    if (m != 0) {
        with(StringTokenizer(readln())) {
            for (i in 0 until m) {
                numList[this.nextToken().toInt()] = false
            }
        }
    }

    result = if (n - 100 >= 0) n - 100 else 100 - n
    result = minOf(result, getClick(n, -1))
    result = minOf(result, getClick(n, 1))

    println(result)
}

fun getClick(num: Int, dir: Int): Int {
    var tempN = num
    var count = 0
    while (true) {
        val len = getDigit(tempN)
        val numSet = getSet(tempN)
        if (numSet.count { numList[it] } == numSet.size) {
            return len + count
        }

        tempN += dir
        count++

        if (dir == -1 && tempN < 0) return Int.MAX_VALUE
        if (dir == 1 && tempN > 1000000) return Int.MAX_VALUE
    }
}

fun getSet(num: Int): Set<Int> {
    val result = mutableSetOf<Int>()
    var useNum = num

    if (num == 0) return setOf(0)

    while (useNum != 0) {
        result.add(useNum % 10)
        useNum /= 10
    }

    return result
}

fun getDigit(num: Int): Int {
    var result = 0
    var useNum = num

    if (num == 0) return 1

    while (useNum != 0) {
        useNum /= 10
        result++
    }

    return result
}


// 시간초과난 코드
import java.util.StringTokenizer

var n: Int = 0
var m: Int = 0

fun main() = with(System.`in`.bufferedReader()) {
    val numList = (0..9).toMutableList()
    var result: Int

    n = readln().toInt()
    m = readln().toInt()

    if (m != 0) {
        with(StringTokenizer(readln())) {
            for (i in 0 until m) {
                numList.remove(this.nextToken().toInt())
            }
        }
    }

    // 1
    result = if (n - 100 >= 0) n - 100 else 100 - n

    // 2
    var tempN = n
    var count = 0
    while (true) {
        val len = getDigit(tempN)
        val numSet = tempN.toString().toList().map { it.digitToInt() }.toSet()
        if (numList.intersect(numSet).size == numSet.size) {
            result = minOf(result, len + count)
            break
        }

        tempN--
        count++
    }

    // 3
    tempN = n
    count = 0
    while (true) {
        val len = getDigit(tempN)
        val numSet = tempN.toString().toList().map { it.digitToInt() }.toSet()
        if (numList.intersect(numSet).size == numSet.size) {
            result = minOf(result, len + count)
            break
        }

        tempN++
        count++

        if (tempN > 1000000) break
    }

    println(result)
}

fun getDigit(num: Int): Int {
    var result = 0
    var useNum = num
    
    while (useNum != 1) {
        useNum /= 10
        result++
    }
    
    return result
}
