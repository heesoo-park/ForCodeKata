class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0
        
        for (idx in 0 until signs.size) {
            if (signs[idx]) answer += absolutes[idx]
            else answer -= absolutes[idx]
        }
        
        return answer
    }
}
