import java.io.BufferedWriter
import java.io.OutputStreamWriter

val setS = mutableSetOf<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val m = readln().toInt()

    repeat(m) {
        val operation = readln().split(' ')

        when (operation[0]) {
            "add" -> add(operation[1].toInt())
            "remove" -> remove(operation[1].toInt())
            "check" -> bw.write("${check(operation[1].toInt())}\n")
            "toggle" -> toggle(operation[1].toInt())
            "all" -> all()
            "empty" -> empty()
        }
    }

    bw.flush()
    bw.close()
}

fun add(x: Int) {
    setS.add(x)
}

fun remove(x: Int) {
    setS.remove(x)
}

fun check(x: Int): Int {
    return if (setS.contains(x)) 1 else 0
}

fun toggle(x: Int) {
    if (check(x) == 1) remove(x) else add(x)
}

fun all() {
    setS.addAll(1..20)
}

fun empty() {
    setS.clear()
}
