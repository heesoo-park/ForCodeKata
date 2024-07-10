class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        val student1 = intArrayOf(1, 2, 3, 4, 5)
        val student2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val student3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        var scores = intArrayOf(0, 0, 0)

        for (i in answers.indices) {
            if (student1[i % 5] == answers[i]) scores[0]++
            if (student2[i % 8] == answers[i]) scores[1]++
            if (student3[i % 10] == answers[i]) scores[2]++
        }

        var maxScore = scores.maxOf { it }
        for (i in scores.indices) {
            if (scores[i] == maxScore) answer += (i + 1)
        }

        return answer
    }
}
