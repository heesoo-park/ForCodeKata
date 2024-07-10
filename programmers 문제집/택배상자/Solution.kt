class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val subContainer = ArrayDeque<Int>()

        var item = 1
        var isBreak = false
        for (seq in order) {
            while (item != seq) {
                if (item < seq) {
                    subContainer.add(item++)
                } else {
                    if (subContainer.last() == seq) {
                        subContainer.removeLast()
                        answer++
                        isBreak = true
                        break
                    } else {
                        return answer
                    }
                }
            }

            if (!isBreak) {
                item++
                answer++
            }
            isBreak = false
        }

        return answer
    }
}
