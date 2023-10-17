class Solution {
    fun solution(num1: Int, num2: Int): Int {
        var temp: Double = num1.toDouble() / num2.toDouble()
        var answer: Double = temp * 1000
        return answer.toInt()
    }
}
