class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        val wall = Array<Boolean>(n + 1) {true}

        section.forEach {
            wall[it] = false
        }

        for (element in section) {
            if (!wall[element]) {
                for (i in element until if (element + m > wall.size) wall.size else element + m) {
                    wall[i] = true
                }
                answer++
            }

            if (!wall.contains(false)) break
        }

        return answer
    }
}
