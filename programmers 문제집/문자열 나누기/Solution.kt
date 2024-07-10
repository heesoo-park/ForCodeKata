class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var start: Char = ' '
        val count = arrayOf(0, 0)

        for (c in s) {
            if (count.maxOf { it } == 0) {
                start = c
                count[0]++
            } else {
                if (c == start) count[0]++
                else count[1]++
            }

            if (count[0] == count[1]) {
                answer++
                count[0] = 0
                count[1] = 0
            }
        }

        if (count.maxOf {it} != 0) {
            answer++
        }

        return answer
    }
}
