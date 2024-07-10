import kotlin.math.abs

class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf(1, 1, 1, 1, 1)

        places.forEachIndexed { idx, place ->
            val peoplePosition = arrayListOf<Pair<Int, Int>>()
            for (i in 0 until 5) {
                for (j in 0 until 5) {
                    if (place[i][j] == 'P') peoplePosition.add(Pair(i, j))
                }
            }

            for (i in peoplePosition.indices) {
                for (j in i + 1 until peoplePosition.size) {
                    if (calManhattanDistance(peoplePosition[i], peoplePosition[j]) <= 2) {
                        if (checkKeepDistance(place, peoplePosition[i], peoplePosition[j]).not()) answer[idx] = 0
                    }
                }
            }
        }
        return answer
    }

    private fun calManhattanDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int {
        return abs(p1.first - p2.first) + abs(p1.second - p2.second)
    }

    private fun checkKeepDistance(place: Array<String>, p1: Pair<Int, Int>, p2: Pair<Int, Int>): Boolean {
        return when {
            p1.first == p2.first -> {
                val mid = if (p1.second > p2.second) p1.second - 1 else p2.second -1
                place[p1.first][mid] == 'X'
            }
            p1.second == p2.second -> {
                val mid = if (p1.first > p2.first) p1.first - 1 else p2.first -1
                place[mid][p1.second] == 'X'
            }
            else -> {
                place[p1.first][p2.second] == 'X' && place[p2.first][p1.second] == 'X'
            }
        }
    }
}
