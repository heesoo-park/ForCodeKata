class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = LongArray(n)
        var X: Long = x.toLong()
        
        for (i in 0..n - 1) {
            answer[i] = X * (i + 1)
        }
        
        return answer
    }
}
