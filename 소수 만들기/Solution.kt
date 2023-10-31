class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
        val setSum = mutableListOf<Int>()

        for (i in 0 until nums.size - 2) {
            for (j in i + 1  until nums.size - 1) {
                for (k in j + 1 until nums.size) {
                    setSum += (nums[i] + nums[j] + nums[k])
                }
            }
        }

        setSum.forEach {
            var isDivided: Boolean = false
            for (i in 2 until it) {
                if (it % i == 0) {
                    isDivided = true
                    break
                }
            }

            if (!isDivided) answer++
        }

        return answer
    }
}
