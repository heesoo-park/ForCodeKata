class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var N: Int = n
        
        while (N != 0) {
            answer += (N % 10)
            N /= 10
        }
        
        return answer
    }
}
