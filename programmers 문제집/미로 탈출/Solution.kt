class Solution {
    private var startQ = ArrayDeque<Pair<Int,Int>>()
    private var leverQ = ArrayDeque<Pair<Int,Int>>()

    private lateinit var visitedStartQ: Array<Array<Boolean>>
    private lateinit var visitedLeverQ: Array<Array<Boolean>>

    lateinit var exitPos: Pair<Int, Int>

    private val dy = listOf(0, 1, 0, -1)
    private val dx = listOf(1, 0, -1, 0)

    fun solution(maps: Array<String>): Int {
        var answer: Int = 0

        visitedStartQ = Array(maps.size) { Array(maps[0].length) { false } }
        visitedLeverQ = Array(maps.size) { Array(maps[0].length) { false } }

        maps.forEachIndexed { idxRow, row ->
            row.forEachIndexed { idxCol, col ->
                when (col) {
                    'S' -> {
                        startQ.add(Pair(idxRow, idxCol))
                        visitedStartQ[idxRow][idxCol] = true
                    }
                    'L' -> {
                        leverQ.add(Pair(idxRow, idxCol))
                        visitedLeverQ[idxRow][idxCol] = true
                    }
                    'E' -> exitPos = Pair(idxRow, idxCol)
                }
            }
        }

        answer += startToLever(maps)
        if (answer == 0) return -1

        val temp = leverToExit(maps)
        return if (temp == 0) -1 else answer + temp
    }

    private fun startToLever(maps: Array<String>): Int {
        var count = 0

        startQ.add(Pair(-1, -1))
        while (startQ.isNotEmpty()) {
            val cur = startQ.removeFirst()

            if (cur.first == -1) {
                if (startQ.isNotEmpty()) {
                    count++
                    startQ.add(Pair(-1, -1))
                }
                continue
            }

            if (maps[cur.first][cur.second] == 'L') return count

            for (i in 0..3) {
                val newRow = cur.first + dy[i]
                val newCol = cur.second + dx[i]

                if (newRow < 0 || newRow >= maps.size || newCol < 0 || newCol >= maps[0].length) continue
                if (visitedStartQ[newRow][newCol]) continue
                if (maps[newRow][newCol] == 'X') continue

                startQ.add(Pair(newRow, newCol))
                visitedStartQ[newRow][newCol] = true
            }
        }

        return 0
    }

    private fun leverToExit(maps: Array<String>): Int {
        var count = 0

        leverQ.add(Pair(-1, -1))
        while (leverQ.isNotEmpty()) {
            val cur = leverQ.removeFirst()

            if (cur.first == -1) {
                if (leverQ.isNotEmpty()) {
                    count++
                    leverQ.add(Pair(-1, -1))
                }
                continue
            }

            if (maps[cur.first][cur.second] == 'E') return count

            for (i in 0..3) {
                val newRow = cur.first + dy[i]
                val newCol = cur.second + dx[i]

                if (newRow < 0 || newRow >= maps.size || newCol < 0 || newCol >= maps[0].length) continue
                if (visitedLeverQ[newRow][newCol]) continue
                if (maps[newRow][newCol] == 'X') continue

                leverQ.add(Pair(newRow, newCol))
                visitedLeverQ[newRow][newCol] = true
            }
        }

        return 0
    }
}
