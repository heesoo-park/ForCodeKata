class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()

        for (a in arr) {
            if (a % divisor == 0) answer += a
        }

        if (answer.isEmpty()) answer += -1
        answer.sort()

        return answer
    }
}
