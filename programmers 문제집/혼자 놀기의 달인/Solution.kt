class Solution {
    private lateinit var visited: Array<Boolean>
    fun solution(cards: IntArray): Int {
        visited = Array(cards.size) { false }
        val groupCount = ArrayList<Int>()

        for (i in cards.indices) {
            if (visited[i].not()) groupCount.add(checkGroup(cards, i))
        }

        groupCount.sortDescending()
        return if (groupCount.size == 1) 0 else groupCount[0] * groupCount[1]
    }

    private fun checkGroup(cards: IntArray, num: Int): Int {
        var count = 0
        var curPos = num
        visited[curPos] = true
        count++

        while (visited[cards[curPos] - 1].not()) {
            curPos = cards[curPos] - 1
            visited[curPos] = true
            count++
        }

        return count
    }
}

// 한 가지 케이스에서 런타임 에러난 코드
class Solution {
    private lateinit var visited: Array<Boolean>
    fun solution(cards: IntArray): Int {
        visited = Array(cards.size) { false }
        val groupCount = ArrayList<Int>()

        for (i in cards.indices) {
            if (visited[i].not()) groupCount.add(checkGroup(cards, i))
        }

        groupCount.sortDescending()
        return groupCount[0] * groupCount[1]
    }

    private fun checkGroup(cards: IntArray, num: Int): Int {
        var count = 0
        var curPos = num
        visited[curPos] = true
        count++

        while (visited[cards[curPos] - 1].not()) {
            curPos = cards[curPos] - 1
            visited[curPos] = true
            count++
        }

        return count
    }
}
