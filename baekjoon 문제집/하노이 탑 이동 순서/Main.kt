var move = 0
var route = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val num = readln().toInt()

    solve(num, 1, 3, 2)
    println(move)
    println(route)
}

fun solve(num: Int, from: Int, to: Int, with: Int) {
    if (num == 1) {
        route.append("$from $to\n")
        move++
        return
    }

    solve(num - 1, from, with, to)
    route.append("$from $to\n")
    move++
    solve(num - 1, with, to, from)
}
