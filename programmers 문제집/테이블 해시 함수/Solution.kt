class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer = 0
        val sortedData = data.sortedWith(compareBy({ it[col - 1] }, { -it[0] }))

        (row_begin..row_end).forEach {
            answer = answer xor sortedData[it - 1].fold(0) { sum, num -> sum + num % it }
        }

        return answer
    }
}
