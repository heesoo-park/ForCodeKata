class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var count = IntArray(10001) {0}
        citations.sort()
        for (i in 0..citations.last()) {
            for (j in citations) {
                if (i <= j) count[i]++
            }

            if (count[i] >= i && answer < i) answer = i
        }

        return answer
    }
}
