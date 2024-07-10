class Solution {
    var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {
        dfs(numbers, 0, target)
        return answer
    }
    
    private fun dfs(numbers: IntArray, idx: Int, target: Int) {
        if (idx == numbers.size) {
            if (numbers.sumOf { it } == target) answer++
            return
        }

        dfs(numbers, idx + 1, target)
        numbers[idx] *= -1
        dfs(numbers, idx + 1, target)
        numbers[idx] *= -1
    }
}
