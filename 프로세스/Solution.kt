class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val process: ArrayDeque<Pair<Int, Boolean>> = ArrayDeque()
        val check: MutableMap<Int, Int> = priorities.toList().groupingBy { it }.eachCount().toMutableMap()

        for (i in priorities.indices) {
            if (location == i) {
                process.add(Pair(priorities[i], true))
            } else {
                process.add(Pair(priorities[i], false))
            }
        }

        var max = check.maxOf { it.key }
        while (true) {
            if (process[0].first >= max) {
                check[max] = check[max]!! - 1
                answer++
                if (check[max] == 0) {
                    check.remove(max)
                    max = if (check.isNotEmpty()) check.maxOf { it.key } else 0
                }
                if (process[0].second) break
                else process.removeFirst()
            } else {
                val pop = process.removeFirst()
                process.add(pop)
            }
        }

        return answer
    }
}
