class Solution {
    private lateinit var map: Array<ArrayList<Pair<Int, Int>>>
    private lateinit var visited: Array<Boolean>
    private lateinit var isArrived: Array<Boolean>
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        map = Array(N + 1) { arrayListOf() }
        visited = Array(N + 1) { false }
        isArrived = Array(N + 1) { false }

        for (i in 1..N) {
            map[i].add(Pair(i, 0))
        }

        for (info in road) {
            map[info[0]].add(Pair(info[1], info[2]))
            map[info[1]].add(Pair(info[0], info[2]))
        }

        dfs(1, 0, k)

        return isArrived.count { it }
    }

    private fun dfs(start: Int, time: Int, limit: Int) {
        for (i in map[start]) {
            if (!visited[i.first] && time + i.second <= limit) {
                visited[i.first] = true
                isArrived[i.first] = true
                dfs(i.first, time + i.second, limit)
                visited[i.first] = false
            }
        }
    }
}

// 1개만 시간초과난 코드
class Solution {
   private lateinit var map: Array<ArrayList<Pair<Int, Int>>>
    private lateinit var visited: Array<Boolean>
    private var isArrived: Boolean = false
    private var answer = 0
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        map = Array(N + 1) { arrayListOf() }
        visited = Array(N + 1) { false }

        for (i in 1..N) {
            map[i].add(Pair(i, 0))
        }

        for (info in road) {
            map[info[0]].add(Pair(info[1], info[2]))
            map[info[1]].add(Pair(info[0], info[2]))
        }

        for (i in 1..N) {
            isArrived = false
            dfs(1, i, 0, k)
        }

        return answer
    }

    private fun dfs(start: Int, end: Int, time: Int, limit: Int) {
        if (start == end) {
            if (time <= limit && !isArrived) {
                isArrived = true
                answer++
            }
            return
        }

        for (i in map[start]) {
            if (!visited[i.first]) {
                if (time + i.second <= limit) {
                    visited[i.first] = true
                    dfs(i.first, end, time + i.second, limit)
                    visited[i.first] = false

                    if (isArrived) return
                }
            }
        }
    }
}

// 4분의 1이 시간초과난 코드
class Solution {
    private lateinit var map: Array<ArrayList<Pair<Int, Int>>>
    private var isArrived: Boolean = false
    private var answer = 0
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        map = Array(N + 1) { arrayListOf() }

        for (i in 1..N) {
            map[i].add(Pair(i, 0))
        }

        for (info in road) {
            map[info[0]].add(Pair(info[1], info[2]))
            map[info[1]].add(Pair(info[0], info[2]))
        }

        for (i in 1..N) {
            isArrived = false
            dfs(1, i, 0, k)
        }

        return answer
    }

    private fun dfs(start: Int, end: Int, time: Int, limit: Int) {
        if (start == end) {
            if (time <= limit && !isArrived) {
                isArrived = true
                answer++
            }
            return
        }

        for (i in 1 until map[start].size) {
            if (time + map[start][i].second <= limit) {
                dfs(map[start][i].first, end, time + map[start][i].second, limit)

                if (isArrived) return
            }
        }
    }
}

// 절반이 시간초과난 코드
class Solution {
    private lateinit var map: Array<ArrayList<Pair<Int, Int>>>
    private lateinit var visited: Array<Boolean>
    private var isArrived: Boolean = false
    private var answer = 0
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        map = Array(N + 1) { arrayListOf() }
        visited = Array(N + 1) { false }

        for (i in 1..N) {
            map[i].add(Pair(i, 0))
        }

        for (info in road) {
            map[info[0]].add(Pair(info[1], info[2]))
            map[info[1]].add(Pair(info[0], info[2]))
        }

        visited[1] = true
        for (i in 1..N) {
            isArrived = false
            dfs(1, i, 0, k)
        }

        return answer
    }

    private fun dfs(start: Int, end: Int, time: Int, limit: Int) {
        if (start == end) {
            if (time <= limit && !isArrived) {
                isArrived = true
                answer++
            }
            return
        }

        for (i in map[start]) {
            if (!visited[i.first]) {
                visited[i.first] = true
                dfs(i.first, end, time + i.second, limit)
                visited[i.first] = false

                if (isArrived) return
            }
        }
    }
}
