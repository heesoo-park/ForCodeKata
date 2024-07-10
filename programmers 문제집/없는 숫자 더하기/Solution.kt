class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 45
        
        for (n in numbers) {
            answer -= n
        }
        
        return answer
    }
}
