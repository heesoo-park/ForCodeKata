import java.io.BufferedWriter
import java.io.OutputStreamWriter

val table = IntArray(101) { 0 }
val visited = BooleanArray(101) { false }
val answer = mutableListOf<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val size = readln().toInt()

    repeat(size) {
        table[it + 1] = readln().toInt()
    }

    for (i in 1..size) {
        resetVisited()
        dfs(i, i)
    }

    bw.write("${answer.size}\n")
    answer.forEach {
        bw.write("$it\n")
    }

    bw.flush()
    bw.close()
}

fun dfs(cur: Int, start: Int) {
    if (visited[cur]) {
        if (start == cur) answer.add(cur)
        return
    }

    visited[cur] = true
    dfs(table[cur], start)
}

fun resetVisited() {
    for (i in visited.indices) {
        visited[i] = false
    }
}
