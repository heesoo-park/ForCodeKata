class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf(51, 51, 0, 0)

        for ((indexRow, line) in wallpaper.withIndex()) {
            for (indexCol in line.indices) {
                if (wallpaper[indexRow][indexCol] == '#') {
                    if (answer[0] > indexRow) answer[0] = indexRow
                    if (answer[1] > indexCol) answer[1] = indexCol
                    if (answer[2] < indexRow + 1) answer[2] = indexRow + 1
                    if (answer[3] < indexCol + 1) answer[3] = indexCol + 1
                }
            }
        }
        return answer
    }
}
