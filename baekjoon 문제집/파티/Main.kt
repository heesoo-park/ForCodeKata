// 최적화한 코드
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.PriorityQueue

data class Info(
    val target: Int,
    val cost: Int
)

private lateinit var routes: Array<MutableList<Info>>
private lateinit var reverseRoutes: Array<MutableList<Info>>
private lateinit var dist: IntArray
private lateinit var visited: BooleanArray
private lateinit var result: IntArray

private const val INF = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m, x) = readln().split(' ').map { it.toInt() }
    routes = Array(n + 1) { mutableListOf() }
    reverseRoutes = Array(n + 1) { mutableListOf() }
    result = IntArray(n + 1) { 0 }

    for (i in 0 until m) {
        val route = readln().split(' ').map { it.toInt() }
        routes[route[0]].add(Info(route[1], route[2]))
        reverseRoutes[route[1]].add(Info(route[0], route[2]))
    }

    dist = IntArray(n + 1) { INF }
    visited = BooleanArray(n + 1) { false }
    reverseSolve(x)
    for (i in 1..n) {
        result[i] += dist[i]
    }

    dist = IntArray(n + 1) { INF }
    visited = BooleanArray(n + 1) { false }
    solve(x)
    for (i in 1..n) {
        result[i] += dist[i]
    }

    bw.write("${result.max()}")
    bw.flush()
    bw.close()
}

fun reverseSolve(start: Int) {
    val q = PriorityQueue<Info> { p1, p2 ->
        when {
            p1.cost > p2.cost -> 1
            p1.cost < p2.cost -> -1
            else -> 0
        }
    }

    q.add(Info(start, 0))
    dist[start] = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (visited[cur.target]) continue
        else visited[cur.target] = true

        for (i in reverseRoutes[cur.target]) {
            val cost = cur.cost + i.cost

            if (cost < dist[i.target]) {
                dist[i.target] = cost
                q.add(Info(i.target, cost))
            }
        }
    }
}

fun solve(start: Int) {
    val q = PriorityQueue<Info> { p1, p2 ->
        when {
            p1.cost > p2.cost -> 1
            p1.cost < p2.cost -> -1
            else -> 0
        }
    }

    q.add(Info(start, 0))
    dist[start] = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (visited[cur.target]) continue
        else visited[cur.target] = true

        for (i in routes[cur.target]) {
            val cost = cur.cost + i.cost

            if (cost < dist[i.target]) {
                dist[i.target] = cost
                q.add(Info(i.target, cost))
            }
        }
    }
}


import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.PriorityQueue

data class Info(
    val target: Int,
    val cost: Int
)

private lateinit var routes: Array<MutableList<Info>>
private lateinit var dist: IntArray
private lateinit var visited: BooleanArray
private lateinit var result: IntArray

private const val INF = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m, x) = readln().split(' ').map { it.toInt() }
    routes = Array(n + 1) { mutableListOf() }
    result = IntArray(n + 1) { 0 }

    for (i in 0 until m) {
        val route = readln().split(' ').map { it.toInt() }
        routes[route[0]].add(Info(route[1], route[2]))
    }

    for (i in 1..n) {
        if (i != x) {
            dist = IntArray(n + 1) { INF }
            visited = BooleanArray(n + 1) { false }
            solve(i, x, false)
        }
    }

    for (i in 1..n) {
        if (i != x) {
            dist = IntArray(n + 1) { INF }
            visited = BooleanArray(n + 1) { false }
            solve(x, i, true)
        }
    }

    bw.write("${result.max()}")
    bw.flush()
    bw.close()
}

fun solve(start: Int, end: Int, isBack: Boolean) {
    val q = PriorityQueue<Info> { p1, p2 ->
        when {
            p1.cost > p2.cost -> 1
            p1.cost < p2.cost -> -1
            else -> 0
        }
    }

    q.add(Info(start, 0))
    dist[start] = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (visited[cur.target]) continue
        else visited[cur.target] = true

        for (i in routes[cur.target]) {
            val cost = cur.cost + i.cost

            if (cost < dist[i.target]) {
                dist[i.target] = cost
                q.add(Info(i.target, cost))
            }
        }
    }

    if (isBack) result[end] += dist[end]
    else result[start] += dist[end]
}
