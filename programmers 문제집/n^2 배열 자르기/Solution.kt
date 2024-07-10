class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = intArrayOf()

        for (i in left..right) {
            answer += (maxOf(i / n, i % n) + 1).toInt()
        }
        
        return answer
    }
}
