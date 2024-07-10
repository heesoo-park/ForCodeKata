class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        var sortArr = score.sortedDescending()

        for (i in sortArr.indices) {
            if (i % m == m - 1) {
                answer += (sortArr[i] * m)
            }
        }

        return answer
    }
}
