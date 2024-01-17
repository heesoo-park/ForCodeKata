import java.util.StringTokenizer

var n = 0
var m = 0
lateinit var city: Array<Array<Int>>
var chickenHouse = ArrayList<Pair<Int, Int>>()
var minChickenDistance = Int.MAX_VALUE
fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        n = this.nextToken().toInt()
        m = this.nextToken().toInt()
    }

    city = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        val st = StringTokenizer(readln())
        for (j in 0 until n) {
            city[i][j] = st.nextToken().toInt()
            if (city[i][j] == 2) {
                chickenHouse.add(Pair(i, j))
            }
        }
    }

    combination(0, 0, ArrayList<Pair<Int, Int>>())
    println(minChickenDistance)
}

fun combination(len: Int, start: Int, pick: ArrayList<Pair<Int, Int>>) {
    if (len == m) {
        var distance = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (city[i][j] == 1) {
                    var min = Int.MAX_VALUE
                    pick.forEach {
                        min = minOf(min, calDist(it.first, it.second, i, j))
                    }
                    distance += min
                }
            }
        }
        minChickenDistance = minOf(minChickenDistance, distance)
        return
    }

    for (i in start until chickenHouse.size) {
        pick.add(chickenHouse[i])
        combination(len + 1, i + 1, pick)
        pick.removeLast()
    }
}

fun calDist(r1: Int, c1: Int, r2: Int, c2: Int): Int {
    var result = 0
    result += if (r1 - r2 < 0) r2 - r1 else r1 - r2
    result += if (c1 - c2 < 0) c2 - c1 else c1 - c2

    return result
}

