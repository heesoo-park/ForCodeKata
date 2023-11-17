class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()

        for (i in 0 until arr1.size) {
            var line = IntArray(arr2[0].size) {0}
            for (j in 0 until arr2[0].size) {
                for (c in arr2.indices) {
                    line[j] += arr1[i][c] * arr2[c][j]
                }
            }

            answer += line
        }

        return answer
    }
}
