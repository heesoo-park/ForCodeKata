class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val students = Array<Int>(n + 1) {1}

        for (i in lost) {
            students[i]--
        }
        for (i in reserve) {
            students[i]++
        }

        for (i in 1 until students.size - 1) {
            if (i < students.size - 1 && students[i] == 2 && students[i + 1] == 0) {
                students[i + 1]++
                students[i]--
            }
            if (students[i + 1] == 2 && students[i] == 0) {
                students[i + 1]--
                students[i]++
            }
        }

        return students.filter { it >= 1 }.size - 1
    }
}
