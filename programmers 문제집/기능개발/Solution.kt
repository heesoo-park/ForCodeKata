class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        var clearLastIdx = 0

        while (clearLastIdx != progresses.size) {
            for (idx in clearLastIdx until progresses.size) {
                progresses[idx] += speeds[idx]
            }

            if (progresses[clearLastIdx] >= 100) {
                var release = 0
                for (idx in clearLastIdx until progresses.size) {
                    if (progresses[idx] >= 100) {
                        clearLastIdx++
                        release++
                    } else {
                        break
                    }
                }
                answer += release
            }
        }

        return answer
    }
}
