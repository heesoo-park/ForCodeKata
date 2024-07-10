class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var hallOfFame = arrayListOf<Int>()

        for (s in score) {
            hallOfFame.add(s)

            hallOfFame.sortDescending()

            if (k > hallOfFame.size) answer += hallOfFame.last()
            else answer += hallOfFame[k - 1]
        }
        return answer
    }
}
