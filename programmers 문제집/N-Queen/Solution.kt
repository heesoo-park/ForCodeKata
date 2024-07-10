class Solution {
    private val chessBoard = Array(13) { Array(13) { 0 } }
    private var result = 0
    fun solution(n: Int): Int {

        for (i in 0 until n) {
            checkPosition(Pair(0, i), n)
            removeAttackRange(Pair(0, i), n)
        }

        return result
    }

    private fun checkPosition(position: Pair<Int, Int>, size: Int) {
        addAttackRange(position, size)

        if (position.first == size) {
            result++
            return
        }

        for (i in 0 until size) {
            if (chessBoard[position.first + 1][i] == 0) {
                checkPosition(Pair(position.first + 1, i), size)
                removeAttackRange(Pair(position.first + 1, i), size)
            }
        }
    }

    private fun addAttackRange(position: Pair<Int, Int>, size: Int) {
        chessBoard[position.first][position.second] = 1

        for (i in 0 until size) {
            if (chessBoard[position.first][i] == 0) chessBoard[position.first][i] =
                -(position.first + 1)
            if (chessBoard[i][position.second] == 0) chessBoard[i][position.second] =
                -(position.first + 1)
        }

        var row = 1
        var col = 1
        while (position.first + row < size && position.second + col < size) {
            if (chessBoard[position.first + row][position.second + col] == 0) chessBoard[position.first + row][position.second + col] =
                -(position.first + 1)

            row++
            col++
        }

        row = 1
        col = 1
        while (position.first - row >= 0 && position.second - col >= 0) {
            if (chessBoard[position.first - row][position.second - col] == 0) chessBoard[position.first - row][position.second - col] =
                -(position.first + 1)

            row++
            col++
        }

        row = 1
        col = 1
        while (position.first + row < size && position.second - col >= 0) {
            if (chessBoard[position.first + row][position.second - col] == 0) chessBoard[position.first + row][position.second - col] =
                -(position.first + 1)

            row++
            col++
        }

        row = 1
        col = 1
        while (position.first - row >= 0 && position.second + col < size) {
            if (chessBoard[position.first - row][position.second + col] == 0) chessBoard[position.first - row][position.second + col] =
                -(position.first + 1)

            row++
            col++
        }
    }

    private fun removeAttackRange(position: Pair<Int, Int>, size: Int) {
        chessBoard[position.first][position.second] = 0
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (chessBoard[i][j] == -(position.first + 1)) chessBoard[i][j] = 0
            }
        }
    }
}
