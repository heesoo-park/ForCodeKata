class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var n_2 = 0
        var n_1 = 1

        for (i in 2..n) {
            answer = (n_1 + n_2) % 1234567
            n_2 = n_1
            n_1 = answer
        }

        return answer
    }
}
