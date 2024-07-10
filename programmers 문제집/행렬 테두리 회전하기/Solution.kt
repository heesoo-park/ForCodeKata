class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        var matrix = Array<IntArray>(rows) { i -> IntArray(columns) { j -> i * columns + j + 1} }

        for (query in queries) {
            var numList = intArrayOf()
            var isClear = false
            var x = query[0] - 1
            var y = query[1] - 1
            var prev = 0
            var cur = matrix[x][y]
            var isLeft = false
            var isRight = true
            var isDown = false
            var isUp = false
            while (!isClear) {
                when {
                    isLeft -> {
                        if (y > query[1] - 1) {
                            prev = cur
                            cur = matrix[x][y - 1]
                            matrix[x][y - 1] = prev
                            numList += prev
                            y--
                        } else {
                            prev = cur
                            cur = matrix[x - 1][y]
                            matrix[x - 1][y] = prev
                            numList += prev
                            x--
                            isLeft = false
                            isUp = true
                        }
                    }
                    isRight -> {
                        if (y < query[3] - 1) {
                            prev = cur
                            cur = matrix[x][y + 1]
                            matrix[x][y + 1] = prev
                            numList += prev
                            y++
                        } else {
                            prev = cur
                            cur = matrix[x + 1][y]
                            matrix[x + 1][y] = prev
                            numList += prev
                            x++
                            isRight = false
                            isDown = true
                        }
                    }
                    isDown -> {
                        if (x < query[2] - 1) {
                            prev = cur
                            cur = matrix[x + 1][y]
                            matrix[x + 1][y] = prev
                            numList += prev
                            x++
                        } else {
                            prev = cur
                            cur = matrix[x][y - 1]
                            matrix[x][y - 1] = prev
                            numList += prev
                            y--
                            isDown = false
                            isLeft = true
                        }
                    }
                    isUp -> {
                        if (x > query[0] - 1) {
                            prev = cur
                            cur = matrix[x - 1][y]
                            matrix[x - 1][y] = prev
                            numList += prev
                            x--
                        } else {
                            isUp = false
                            isClear = true
                        }
                    }
                }
            }
            answer += numList.minOf { it }
        }

        return answer
    }
}
