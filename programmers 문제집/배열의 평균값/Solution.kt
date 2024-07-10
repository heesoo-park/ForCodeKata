class Solution {
    fun solution(numbers: IntArray): Double {
        var answer: Double = 0.0
        
        for (item in numbers) {
            answer += item.toDouble()
        }
        
        return answer/numbers.size
        
        // return answer.average() 도 가능하다
    }
}
