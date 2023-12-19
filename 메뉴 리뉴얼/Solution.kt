class Solution {
    lateinit var candidate: MutableMap<String, Int>
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        var check = orders.groupingBy { it.length }.eachCount()

        for (c in course) {
            var sum = 0
            check.forEach { (key, value) ->
                if (key >= c) sum += value
            }
            if (sum < 2) continue

            candidate = mutableMapOf()
            for (order in orders) {
                if (order.length < c) continue
                combination(c, 0, 0, order)
            }

            val max = candidate.maxOf { it.value }
            if (max < 2) continue

            candidate.forEach { (key, value) ->
                if (value == max) answer += key
            }
        }

        return answer.sortedArray()
    }

    val picked = StringBuilder()
    private fun combination(depth: Int, add: Int, start: Int, order: String) {
        if (depth == add) {
            val str = picked.split("").sorted().joinToString("")
            if (candidate.containsKey(str)) {
                candidate[str] = candidate[str]!! + 1
            } else {
                candidate[str] = 1
            }
            return
        }

        for (i in start until order.length) {
            picked.append(order[i])
            combination(depth, add + 1, i + 1, order)
            picked.deleteCharAt(picked.lastIndex)
        }
    }
}
