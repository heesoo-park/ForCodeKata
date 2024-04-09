import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    val result = IntArray(n) { 0 }
    val stack = Stack<Int>()
    val towers = readln().split(' ').map { it.toInt() }


    for (i in towers.size - 1 downTo 0) {
        while (stack.isNotEmpty() && towers[stack.peek()] < towers[i]) {
            result[stack.pop()] = i + 1
        }

        stack.push(i)
    }

    result.forEach {
        bw.write("$it ")
    }
    bw.flush()
    bw.close()
}
