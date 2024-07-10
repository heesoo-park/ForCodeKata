class Solution {
    fun solution(angle: Int): Int {
        when (angle) {
            in 1..89 -> {
                return 1
            }
            90 -> {
                return 2
            }
            in 91..179 -> {
                return 3
            }
            180 -> {
                return 4
            }
            else -> {
                return 0
            }
        }
    }
}
