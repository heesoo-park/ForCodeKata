import kotlin.math.*

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var A = a
        var B = b

        for (i in 1..sqrt(n.toDouble()).toInt()) {
            if (checkBreak(A, B) || checkBreak(B, A)) break

            A = checkNextNumber(A)
            B = checkNextNumber(B)
            answer++
        }

        return answer + 1
    }
    
    private fun checkNextNumber(idx: Int): Int {
        return if (idx % 2 == 0) idx / 2 else (idx + 1) / 2
    }
    
    private fun checkBreak(idx1: Int, idx2: Int): Boolean {
        if (idx1 + 1 == idx2 && idx1 / 2 + 1 == idx2 / 2) {
            return true
        }
        return false
    }
}
