import java.util.PriorityQueue

// 인접 리스트 형태
private lateinit var map: Array<MutableList<Route>>
// 각 헛간까지의 최소 거리 저장 배열
private lateinit var dist: IntArray
private lateinit var visited: BooleanArray
private const val INF = Int.MAX_VALUE

data class Route(
    val endPoint: Int,
    val cost: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readln().split(' ').map { it.toInt() }
    map = Array(n + 1) { mutableListOf() }
    dist = IntArray(n + 1) { INF }
    visited = BooleanArray(n + 1) { false }

    // 양방향 저장
    for (i in 0 until m) {
        val route = readln().split(' ').map { it.toInt() }
        map[route[0]].add(Route(route[1], route[2]))
        map[route[1]].add(Route(route[0], route[2]))
    }

    solve()
    println(dist[n])
}

fun solve() {
    // 고차함수를 이용해서 최소값이 가장 루트에 오도록 우선순위 변경
    val q = PriorityQueue<Route> { p1, p2 ->
        when {
            p1.cost > p2.cost -> 1
            p1.cost < p2.cost -> -1
            else -> 0
        }
    }

    // 시작 위치 세팅
    q.add(Route(1, 0))
    dist[1] = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()
        // 이미 왔었던 헛간이라면 패스
        if (visited[cur.endPoint]) continue
        else visited[cur.endPoint] = true

        // 이어져 있는 경로를 순회
        for (i in map[cur.endPoint]) {
            val cost = cur.cost + i.cost
            // 최소 거리 저장 배열에 들어가 있는 값보다 계산한 값이 작다면
            // 값 갱신하고 우선순위 큐에 삽입
            if (cost < dist[i.endPoint]) {
                dist[i.endPoint] = cost
                q.add(Route(i.endPoint, cost))
            }
        }
    }
}
