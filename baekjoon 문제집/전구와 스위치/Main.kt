var answer = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val cur = readln().chunked(1).map { it != "0" }
    val target = readln().chunked(1).map { it != "0" }

    checkLight(n, cur, target, true)
    checkLight(n, cur, target, false)

    if (answer != Int.MAX_VALUE) println(answer)
    else println(-1)
}

fun checkLight(n: Int, lights: List<Boolean>, target: List<Boolean>, isZeroReversed: Boolean) {
    var temp = lights.toMutableList()
    var cnt = 0

    if (isZeroReversed) {
        toggleLight(temp, 0)
        cnt++
    }

    for (i in 1 until n) {
        if (temp[i - 1] != target[i - 1]) {
            toggleLight(temp, i)
            cnt++
        }
    }

    if (temp == target) answer = minOf(answer, cnt)
}

fun toggleLight(lights: MutableList<Boolean>, switch: Int) {
    if (switch > 0) lights[switch - 1] = !lights[switch - 1]
    lights[switch] = !lights[switch]
    if (switch < lights.size - 1) lights[switch + 1] = !lights[switch + 1]
}
