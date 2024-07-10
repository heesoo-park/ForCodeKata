class Solution {
    fun solution(x: Int): Boolean {
        var temp: Int = x
        var sumValue = 0

        while (temp >= 1) {
            sumValue += (temp % 10)
            temp /= 10
        }

        return x % sumValue == 0
    }
}
