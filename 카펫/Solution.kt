class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        var totalGrid = brown + yellow

        for (row in 3..totalGrid / 3) {
            if (totalGrid % row != 0) continue

            var temp = totalGrid / row * 2 + (row - 2) * 2
            if (temp == brown) {
                answer += totalGrid / row
                answer += row
                break
            }
        }
        
        return answer
    }
}
