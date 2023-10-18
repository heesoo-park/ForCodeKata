class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        var A = a
        var B = b
        
        if (A > B) {
            A = B.also {B = A}
        }
        
        if (A == B) return A.toLong()
        
        for (i in A..B) {
            answer += i.toLong()
        }
        return answer
    }
}
