class Solution {
    private var answer = arrayOf<IntArray>()
    fun solution(n: Int): Array<IntArray> {
        solve(n, 1, 3, 2)
        return answer
    }

    private fun solve(num: Int, from: Int, to: Int, temp: Int) {
        if (num == 1) {
            answer += intArrayOf(from, to)
            return
        }

        solve(num - 1, from, temp, to)
        answer += intArrayOf(from, to)
        solve(num - 1, temp, to, from)
    }
}
