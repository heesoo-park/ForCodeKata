import kotlin.math.abs

class Solution {
    private lateinit var network: Array<Array<Boolean>>
    private lateinit var visited: Array<Boolean>
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = 100
        network = Array(n + 1) { Array(n + 1) { false } }

        for (wire in wires) {
            network[wire[0]][wire[1]] = true
            network[wire[1]][wire[0]] = true
        }

        for (wire in wires) {
            visited = Array(n + 1) { false }

            network[wire[0]][wire[1]] = false
            network[wire[1]][wire[0]] = false

            answer = minOf(answer, diffTower(n))

            network[wire[0]][wire[1]] = true
            network[wire[1]][wire[0]] = true
        }
        return answer
    }

    private fun diffTower(n: Int): Int {
        var sum = 0
        val q = ArrayDeque<Int>()
        q.add(1)
        visited[1] = true
        sum++

        while (!q.isEmpty()) {
            val curNum = q.removeFirst()

            for (i in 1 until network.size) {
                if (network[curNum][i] && !visited[i]) {
                    q.add(i)
                    visited[i] = true
                    sum++
                }
            }
        }

        return abs(n - sum * 2)
    }
}
