class Solution {
    fun solution(n: Int): Long {
        val dp = LongArray(2001)

        dp[1] = 1
        dp[2] = 2
        
        for (i in 3..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
        }

        return dp[n]
    }
}
