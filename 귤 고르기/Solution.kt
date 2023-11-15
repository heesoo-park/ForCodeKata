// 성공한 코드
class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var group = mutableMapOf<Int, Int>()
        val itemSet = tangerine.toSortedSet()
        var answer: Int = itemSet.size

        for (item in itemSet) {
            group[item] = 0
        }
        for (item in tangerine) {
            group[item] = group[item]!!.plus(1)
        }

        val sortedGroup = group.toList().sortedBy { it.second }.toMap()
        var sub = 0
        for (i in sortedGroup) {
            sub += i.value
            answer--

            when {
                tangerine.size - sub == k -> {
                    break
                }
                tangerine.size - sub < k -> {
                    answer++
                    break
                }
                answer == 1 -> {
                    break
                }
            }
        }
        return answer
    }
}

// 실패한 코드
class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var group = mutableMapOf<Int, Int>()
        val itemSet = tangerine.toSortedSet()
        var answer: Int = itemSet.size

        for (item in itemSet) {
            group[item] = 0
        }
        for (item in tangerine) {
            group[item] = group[item]!!.plus(1)
        }
        
        val sortedGroup = group.toList().sortedBy { it.second }.toMap()
        var sub = 0
        for (i in sortedGroup) {
            sub += i.value
            answer--

            if (tangerine.size - sub <= k) {
                break
            }
            if (answer == 1) break
        }

        return answer
    }
}
