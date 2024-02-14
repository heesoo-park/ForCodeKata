// 2차원 배열로 통과한 코드
private lateinit var chessBoard: Array<Array<Int>>
private var n = 0
private var answer = 0
fun main() = with(System.`in`.bufferedReader()) {
    n = readln().toInt()
    chessBoard = Array(n) { Array(n) { 0 } }

    deployQueen(0)
    println(answer)
}

fun deployQueen(row: Int) {
    if (row == n) {
        answer++
        return
    }

    for (i in 0 until n) {
        if (chessBoard[row][i] == 0) {
            setAttachRange(row, i)
            deployQueen(row + 1)
            deleteAttackRange(row)
        }
    }
}

fun setAttachRange(row: Int, col: Int) {
    for (i in chessBoard.indices) {
        if (chessBoard[row][i] == 0) chessBoard[row][i] = -(row + 1)
        if (chessBoard[i][col] == 0) chessBoard[i][col] = -(row + 1)
    }

    var r = 1
    var c = 1
    while (row + r < n && col + c < n) {
        if (chessBoard[row + r][col + c] == 0) chessBoard[row + r][col + c] = -(row + 1)
        r++; c++
    }

    r = 1
    c = 1
    while (row + r < n && col - c >= 0) {
        if (chessBoard[row + r][col - c] == 0) chessBoard[row + r][col - c] = -(row + 1)
        r++; c++
    }
}

fun deleteAttackRange(row: Int) {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (chessBoard[i][j] == -(row + 1)) chessBoard[i][j] = 0
        }
    }
}
