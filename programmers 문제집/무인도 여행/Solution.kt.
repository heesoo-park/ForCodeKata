class Solution {
    private val dy = listOf(0, 1, 0, -1)
    private val dx = listOf(1, 0, -1, 0)
    
    fun solution(maps: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val visited = Array<BooleanArray>(maps.size) { BooleanArray(maps[0].length) {false} }

        for (i in maps.indices) {
            for (j in maps[0].indices) {
                if (!visited[i][j] && maps[i][j] != 'X') {
                    answer += bfs(maps, visited, i, j)
                }
            }
        }

        return if (answer.isEmpty()) intArrayOf(-1) else answer.sortedArray()
    }
    
    private fun bfs(maps: Array<String>, visited: Array<BooleanArray>, row: Int, col: Int): Int {
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(Pair(row, col))
        visited[row][col] = true

        var sum = (maps[row][col] - '0')
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()

            for (i in 0..3) {
                val nextRow = cur.first + dy[i]
                val nextCol = cur.second + dx[i]

                if (nextRow < 0 || nextRow >= maps.size || nextCol < 0 || nextCol >= maps[0].length) continue
                if (visited[nextRow][nextCol]) continue

                if (maps[nextRow][nextCol] != 'X') {
                    visited[nextRow][nextCol] = true
                    q.add(Pair(nextRow, nextCol))
                    sum += (maps[nextRow][nextCol] - '0')
                }
            }
        }

        return sum
    }
}
