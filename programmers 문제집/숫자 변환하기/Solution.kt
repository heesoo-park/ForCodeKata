// 상향식
class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0

        var dp = IntArray(y + 1) { 0 }
        var q = ArrayDeque<Int>()

        q.add(x)
        while (!q.isEmpty()) {
            val cur = q.removeFirst()

            if (cur + n <= y && dp[cur + n] == 0) {
                dp[cur + n] = dp[cur] + 1
                q.add(cur + n)
            }

            if (cur * 2 <= y && dp[cur * 2] == 0) {
                dp[cur * 2] = dp[cur] + 1
                q.add(cur * 2)
            }

            if (cur * 3 == 0 && dp[cur * 3] == 0) {
                dp[cur * 3] = dp[cur] + 1
                q.add(cur * 3)
            }
        }

        return if (dp[y] == 0) -1 else dp[y]
    }
}

// 하향식
class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0

        var dp = IntArray(y + 1) { 0 }
        var q = ArrayDeque<Int>()

        q.add(y)
        while (!q.isEmpty()) {
            val cur = q.removeFirst()

            if (cur - n >= x && dp[cur - n] == 0) {
                dp[cur - n] = dp[cur] + 1
                q.add(cur - n)
            }

            if (cur % 2 == 0 && cur / 2 >= x && dp[cur / 2] == 0) {
                dp[cur / 2] = dp[cur] + 1
                q.add(cur / 2)
            }

            if (cur % 3 == 0 && cur / 3 >= x && dp[cur / 3] == 0) {
                dp[cur / 3] = dp[cur] + 1
                q.add(cur / 3)
            }
        }

        return if (dp[x] == 0) -1 else dp[x]
    }
}

// 다른 문제 풀었던 기억을 가지고 짰지만 80% 정도의 정답률을 가진 코드(3개 틀림)
class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        var dp = IntArray(y + 1) { 0 }
        
        if (x == y) return 0
        
        for (i in x + 1..y) {
            if (i - n >= x) dp[i] = dp[i - n] + 1
            if (i % 2 == 0) dp[i] = dp[i].coerceAtMost(dp[i / 2] + 1)
            if (i % 3 == 0) dp[i] = dp[i].coerceAtMost(dp[i / 3] + 1)
        }

        return if (dp[y] == 0) -1 else dp[y]
    }
}

// 다 해결한 줄 알았지만 90% 정도의 정답률을 가진 코드(2개 틀림)
class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        var dp = IntArray(y + 1) { 1000000 }

        if (x == y) return 0

        dp[x] = 0
        for (i in x + 1..y) {
            if (i - n >= x && (i - x) % n == 0) dp[i] = dp[i - n] + 1
            if (i % 2 == 0) dp[i] = minOf(dp[i], dp[i / 2] + 1)
            if (i % 3 == 0) dp[i] = minOf(dp[i], dp[i / 3] + 1)
        }

        return if (dp[y] == 1000000) -1 else dp[y]
    }
}

// 해결된 코드...휴
class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        var dp = IntArray(y + 1) { 1000000 }

        if (x == y) return 0

        dp[x] = 0
        for (i in x + 1..y) {
            if (i - n >= x) dp[i] = minOf(dp[i], dp[i - n] + 1)
            if (i % 2 == 0) dp[i] = minOf(dp[i], dp[i / 2] + 1)
            if (i % 3 == 0) dp[i] = minOf(dp[i], dp[i / 3] + 1)
        }

        return if (dp[y] == 1000000) -1 else dp[y]
    }
}
