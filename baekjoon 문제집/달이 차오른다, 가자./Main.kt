import java.util.LinkedList

val dy = arrayOf(0, 1, 0, -1)
val dx = arrayOf(1, 0, -1, 0)
val visited = Array(1 shl 7) { Array(50) { BooleanArray(50) } }

// BFS에서 사용할 순간순간의 정보가 담긴 데이터 클래스
data class Pos(
    val r: Int,
    val c: Int,
    val key: Int,
    val cnt: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    // 미로의 가로 세로 길이
    val (n, m) = readLine().split(' ').map { it.toInt() }
    // 민식이의 row 시작 위치
    var sr = 0
    // 민식이의 column 시작 위치
    var sc = 0
    // 미로 모양
    val maze = Array(n) { r ->
        val row = readLine()
        CharArray(m) { c ->
            var pos = row[c]
            if (row[c] == '0') {
                sr = r
                sc = c
                pos = '.'
            }
            pos
        }
    }

    println(bfs(sr, sc, n, m, maze))
    close()
}

fun bfs(sr: Int, sc: Int, n: Int, m: Int, maze: Array<CharArray>): Int {
    // 시작위치 큐에 넣음
    val q = LinkedList<Pos>()
    q.add(Pos(sr, sc, 1, 0))
    visited[1][sr][sc] = true

    while (q.isNotEmpty()) {
        // 큐에서 하나 뺌
        val cur = q.poll()
        // 네 방향 체크
        for (i in 0 until 4) {
            val new_r = cur.r + dy[i]
            val new_c = cur.c + dx[i]
            var keys = cur.key

            // 패스하는 조건들
            if (new_r !in 0 until n || new_c !in 0 until m) continue
            if (visited[keys][new_r][new_c]) continue
            if (maze[new_r][new_c] == '#') continue

            // 출구인 경우
            if (maze[new_r][new_c] == '1') return cur.cnt + 1

            if (maze[new_r][new_c] in 'A'..'F') { // 문을 만난 경우
                if (keys and (1 shl (maze[new_r][new_c] - 'A' + 1)) != 0) { // 열쇠가 있다면 큐에 추가
                    q.add(Pos(new_r, new_c, keys, cur.cnt + 1))
                    visited[keys][new_r][new_c] = true
                } else { // 열쇠가 없다면 패스
                    continue
                }
            } else if (maze[new_r][new_c] in 'a'..'f') { // 열쇠를 찾으면 열쇠 리스트 갱신하고 큐에 추가
                keys = keys or (1 shl (maze[new_r][new_c] - 'a' + 1))
                q.add(Pos(new_r, new_c, keys, cur.cnt + 1))
                visited[keys][new_r][new_c] = true
            } else { // 그 외에는 그냥 큐에 추가
                q.add(Pos(new_r, new_c, keys, cur.cnt + 1))
                visited[keys][new_r][new_c] = true
            }
        }
    }

    // 미로 탈출 방법이 없는 경우
    return -1
}
