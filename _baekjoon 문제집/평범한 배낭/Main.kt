// DP로 풀어낸 코드
import java.util.StringTokenizer

var n = 0
var k = 0
lateinit var itemList: Array<Pair<Int, Int>>
fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }

    itemList = Array(n) {
        with(StringTokenizer(readln())) {
            Pair(nextToken().toInt(), nextToken().toInt())
        }
    }

    solve()
}

fun solve() {
    val dp = Array(k + 1) { 0 }

    for (i in itemList) {
        for (j in k downTo i.first) {
            dp[j] = maxOf(dp[j], dp[j - i.first] + i.second)
        }
    }

    println(dp[k])
}

// 재귀로 풀었다가 시간초과난 코드
import java.util.StringTokenizer

var maxValue = -1
var itemList: Array<Pair<Int, Int>> = arrayOf()
fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    for (i in 0 until n) {
        val item = readln().split(" ").map { it.toInt() }
        itemList += Pair(item[0], item[1])
    }

    solve(-1, k, 0, 0)

    println(maxValue)
}

fun solve(start: Int, limit: Int, weight: Int, sum: Int) {
    if (weight <= limit) {
        maxValue = maxOf(sum, maxValue)
    } else {
        return
    }

    for (i in start + 1 until itemList.size) {
        solve(i, limit, weight + itemList[i].first, sum + itemList[i].second)
    }
}
