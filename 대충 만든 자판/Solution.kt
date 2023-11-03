class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        for (target in targets) {
            val checkCount = Array<Int>(target.length) {0}

            for ((index, c) in target.withIndex()) {
                for (key in keymap) {
                    if (!key.contains(c)) continue
                    if (checkCount[index] != 0 && checkCount[index] > key.indexOf(c) + 1 || checkCount[index] == 0) {
                        checkCount[index] = key.indexOf(c) + 1
                    }
                }
            }

            answer += if (!checkCount.contains(0)) checkCount.sumOf { it } else -1
        }

        return answer
    }
}
