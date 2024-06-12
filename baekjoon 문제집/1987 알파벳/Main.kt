import java.io.*
import java.util.*

private val board = Array(20) { CharArray(20) }
private val visited = BooleanArray(26)
private val dy = arrayOf(0, 1, 0, -1)
private val dx = arrayOf(1, 0, -1, 0)
private var result = 0

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    
    for (i in 0 until r) {
        val str = br.readLine()
        for (j in 0 until c) {
            board[i][j] = str[j]
        }
    }
    
    visited[board[0][0] - 'A'] = true
    dfs(r, c, 0, 0, 1)
    
    println(result)
}

fun dfs(row: Int, col: Int, startRow: Int, startCol: Int, cnt: Int) {
    if (result < cnt) result = cnt

    for (i in 0 until 4) {
        val newRow = startRow + dy[i]
        val newCol = startCol + dx[i]
        
        if (newRow in 0 until row && newCol in 0 until col) {
            if (!visited[board[newRow][newCol] - 'A']) {
                visited[board[newRow][newCol] - 'A'] = true
                dfs(row, col, newRow, newCol, cnt + 1)           
                visited[board[newRow][newCol] - 'A'] = false 
            }
        }
    }
}

// 틀린 코드
import java.io.*
import java.util.*

private val board = Array(20) { CharArray(20) }
private val visited = BooleanArray(26)
private val dy = arrayOf(0, 1, 0, -1)
private val dx = arrayOf(1, 0, -1, 0)
private var result = 0

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    
    for (i in 0 until r) {
        val str = br.readLine()
        for (j in 0 until c) {
            board[i][j] = str[j]
        }
    }
    
    dfs(r, c, 0, 0, 0)
    
    println(result)
}

fun dfs(row: Int, col: Int, startRow: Int, startCol: Int, cnt: Int) {
    if (result < cnt) result = cnt

    for (i in 0 until 4) {
        val newRow = startRow + dy[i]
        val newCol = startCol + dx[i]
        
        if (newRow in 0 until row && newCol in 0 until col) {
            if (!visited[board[startRow][startCol] - 'A']) {
                visited[board[startRow][startCol] - 'A'] = true
                dfs(row, col, newRow, newCol, cnt + 1)           
                visited[board[startRow][startCol] - 'A'] = false 
            }
        }
    }
}

// 시간초과난 코드
import java.io.*
import java.util.*

private val board = Array(20) { CharArray(20) }
private val dy = arrayOf(0, 1, 0, -1)
private val dx = arrayOf(1, 0, -1, 0)
private var result = 0

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    
    for (i in 0 until r) {
        val str = br.readLine()
        for (j in 0 until c) {
            board[i][j] = str[j]
        }
    }
    
    dfs(r, c, 0, 0, mutableListOf<Char>())
    
    println(result)
}

fun dfs(row: Int, col: Int, startRow: Int, startCol: Int, check: MutableList<Char>) {
    if (check.contains(board[startRow][startCol])) {
        if (check.size > result) result = check.size
        
        return
    }
    
    check.add(board[startRow][startCol])
    for (i in 0 until 4) {
        val newRow = startRow + dy[i]
        val newCol = startCol + dx[i]
        
        if (newRow in 0 until row && newCol in 0 until col) {
            dfs(row, col, newRow, newCol, check)            
        }
    }
    check.remove(board[startRow][startCol])
}
