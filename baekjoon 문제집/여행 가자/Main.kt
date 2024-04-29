import java.io.BufferedWriter
import java.io.OutputStreamWriter

private val cities = IntArray(201) { it }

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    val m = readln().toInt()

    repeat(n) { num ->
        readln().split(' ').forEachIndexed { index, connection ->
            if (connection == "1") {
                union(num + 1, index + 1)
            }
        }
    }

    var root = 0
    var pass = false
    readln().split(' ').map { it.toInt() }.forEachIndexed { index, num ->
        if (index == 0) {
            root = find(num)
        } else {
            if (!pass && find(root) != find(num)) {
                bw.write("NO")
                pass = true
            }
        }
    }


    if (!pass) bw.write("YES")
    bw.flush()
    bw.close()
}

fun union(c1: Int, c2: Int) {
    val c1Parent = find(c1)
    val c2Parent = find(c2)

    if (c1Parent < c2Parent) cities[c2Parent] = c1Parent
}

fun find(num: Int): Int {
    return if (cities[num] == num) num
    else {
        cities[num] = find(cities[num])
        cities[num]
    }
}
