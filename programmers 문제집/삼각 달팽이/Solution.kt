class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var triangle = Array(n) {IntArray(n) {0} }
        var visited = Array(n) {BooleanArray(n) {false} }

        val totalNum = n * (n + 1) / 2
        var curNum = 1
        var row = 0
        var col = 0
        var isLeft = true
        var isBottom = false
        var isRight = false

        while (true) {
            triangle[row][col] = curNum
            visited[row][col] = true

            when {
                isLeft -> {
                    if (triangle.size == row + 1 || visited[row + 1][col]) {
                        isLeft = false
                        isBottom = true
                        col++
                    } else {
                        row++
                    }
                }
                isBottom -> {
                    if (row == col || visited[row][col + 1]) {
                        isBottom = false
                        isRight = true
                        row--
                        col--
                    } else {
                        col++
                    }
                }
                isRight -> {
                    if (visited[row - 1][col - 1]) {
                        isRight = false
                        isLeft = true
                        row++
                    } else {
                        row--
                        col--
                    }
                }
            }

            if (curNum == totalNum) break
            curNum++
        }

        triangle.forEach {
            answer += it.filter { num -> num != 0 }
        }
        
        return answer
    }
}

// 3가지 케이스에 대해 시간초과가 난 케이스
class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var triangle = arrayOf<IntArray>()
        var visited = arrayOf<BooleanArray>()

        for (i in 0 until n) {
            triangle += IntArray(i + 1) {0}
            visited += BooleanArray(i + 1) {false}
        }

        val totalNum = n * (n + 1) / 2
        var curNum = 1
        var row = 0
        var col = 0
        var isLeft = true
        var isBottom = false
        var isRight = false

        while (true) {
            triangle[row][col] = curNum
            visited[row][col] = true

            when {
                isLeft -> {
                    if (triangle.size == row + 1 || visited[row + 1][col]) {
                        isLeft = false
                        isBottom = true
                        col++
                    } else {
                        row++
                    }
                }
                isBottom -> {
                    if (triangle[row].size == col + 1 || visited[row][col + 1]) {
                        isBottom = false
                        isRight = true
                        row--
                        col--
                    } else {
                        col++
                    }
                }
                isRight -> {
                    if (visited[row - 1][col - 1]) {
                        isRight = false
                        isLeft = true
                        row++
                    } else {
                        row--
                        col--
                    }
                }
            }

            if (curNum == totalNum) break
            curNum++
        }

        triangle.forEach {
            it.forEach { num ->
                answer += num
            }
        }
        
        return answer
    }
}
