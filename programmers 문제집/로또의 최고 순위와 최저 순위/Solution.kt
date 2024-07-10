class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        var cnt = 0
        val zeroCnt = lottos.count { it == 0}
        lottos.forEach {
            if (it != 0 && win_nums.contains(it)) cnt++
        }

        answer += when {
            cnt + zeroCnt == 6 -> 1
            cnt + zeroCnt == 5 -> 2
            cnt + zeroCnt == 4 -> 3
            cnt + zeroCnt == 3 -> 4
            cnt + zeroCnt == 2 -> 5
            else -> 6
        }

        answer += when (cnt) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
        
        return answer
    }
}
