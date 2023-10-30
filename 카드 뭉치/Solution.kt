class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var pos1: Int = 0
        var pos2: Int = 0
        var step: Int = 0

        while (step < goal.size) {
            if (pos1 < cards1.size && goal[step] == cards1[pos1]) {
                pos1++
                step++
            } else if (pos2 < cards2.size && goal[step] == cards2[pos2]) {
                pos2++
                step++
            } else {
                break
            }
        }

        return if (step == goal.size) "Yes" else "No"
    }
}
