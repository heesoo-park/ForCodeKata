class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        var size1: Int = arr1.size
        var size2: Int = arr1[0].size

        for (r in 0 until size1) {
            var curArr = IntArray(size2)
            for (c in 0 until size2) {
                curArr[c] = (arr1[r][c] + arr2[r][c])
            }

            answer += curArr
        }
        return answer
    }
}
