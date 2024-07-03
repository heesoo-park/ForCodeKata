fun main() = with(System.`in`.bufferedReader()) {
    val testCase = readln().toInt()
    var answer = IntArray(testCase) {0}

    for (i in 0 until testCase) {
        val num = readln().toInt()

        solve(num, answer, i)
    }

    answer.forEach {
        println(it)
    }
}

fun solve(num: Int, cnt: IntArray, idx: Int) {
    if (num == 0) {
        cnt[idx]++
        return
    }

    for (i in 1..3) {
        if (num - i >= 0) solve(num - i, cnt, idx)
    }
}
