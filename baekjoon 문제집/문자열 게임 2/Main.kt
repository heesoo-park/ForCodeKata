import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = readln().toInt()

    repeat(t) {
        val str = readln()
        val k = readln().toInt()
        var shortest = Int.MAX_VALUE
        var longest = Int.MIN_VALUE

        if (k == 1) {
            bw.write("1 1\n")
        } else {
            val counting = str.groupingBy { it }.eachCount().filter { it.value >= k }.keys
            if (counting.isNotEmpty()) {
                for (i in str.indices) {
                    if (str[i] !in counting) continue

                    var cnt = 1
                    for (j in i + 1 until str.length) {
                        if (str[i] == str[j]) cnt++

                        if (cnt == k) {
                            shortest = shortest.coerceAtMost(j - i + 1)
                            longest = longest.coerceAtLeast(j - i + 1)
                            break
                        }
                    }
                }

                bw.write("$shortest $longest \n")
            } else {
                bw.write("-1\n")
            }
        }
    }

    bw.flush()
    bw.close()
}


// 시간초과난 코드
import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = readln().toInt()

    repeat(t) {
        val str = StringBuilder(readln())
        val k = readln().toInt()
        var shortest = ""
        var longest = ""

        for (i in k .. str.length) {
            for (j in 0 .. str.length - i) {
                val subString = str.substring(j, j + i)
                val counting = subString.groupingBy { it }.eachCount()

                if (counting.filter { it.value == k }.isNotEmpty()) {
                    if (shortest == "") shortest = subString
                    if (longest.length < subString.length && subString[0] == subString.last() && counting[subString.last()]!! == k) longest = subString
                }
            }
        }

        if (shortest == "" || longest == "") {
            bw.write("-1\n")
        } else {
            bw.write("${shortest.length} ${longest.length}\n")
        }
    }

    bw.flush()
    bw.close()
}
