class Solution {
    fun solution(n: Long): Long {
        var x: Long = 1

        while (x * x <= n) {
            if (x * x == n) return (x + 1) * (x + 1)
            x += 1
        }
        return -1
    }
}
