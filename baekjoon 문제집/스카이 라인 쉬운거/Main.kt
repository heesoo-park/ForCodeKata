import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Stack

val stack = Stack<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    var cnt = 0

    repeat(n) {
        val cur = readln().split(' ')[1].toInt()

        while (stack.isNotEmpty() && stack.peek() > cur) {
            stack.pop()
            cnt++
        }

        if (cur != 0) {
            if (stack.isEmpty()) {
                stack.push(cur)
            } else {
                if (stack.peek() != cur) stack.push(cur)
            }
        }
    }

    while (stack.isNotEmpty()) {
        stack.pop()
        cnt++
    }

    bw.write("$cnt")
    bw.flush()
    bw.close()
}
