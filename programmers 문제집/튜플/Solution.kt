class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        var len = s.count { it == '{' } - 1

        var numLists = Array<IntArray>(len) { intArrayOf() }
        var stack = ArrayDeque<Char>()
        var idx = -1
        var numList = intArrayOf()
        var num = StringBuilder()
        for (i in 1 until s.length - 1) {
            when (s[i]) {
                '{' -> {
                    idx++
                    stack.add(s[i])
                }
                '}' -> {
                    numList += num.toString().toInt()
                    numLists[idx] += numList
                    numList = intArrayOf()
                    num.clear()
                    stack.removeLast()
                }
                ',' -> {
                    if (stack.isNotEmpty()) {
                        numList += num.toString().toInt()
                        num.clear()
                    }
                }
                else -> {
                    num.append(s[i])
                }
            }
        }

        numLists = numLists.sortedBy { it.size }.toTypedArray()
        for (item in numLists) {
            val set = answer.toSet()
            val subtract = item.subtract(set)
            answer += subtract
        }

        return answer
    }
}
