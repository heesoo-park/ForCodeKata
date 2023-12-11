class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf(0, sequence.size - 1)
        var sum = sequence[0]
        var left = 0
        var right = 1

        while (left < right) {
            if (sum == k) {
                if (answer[1] - answer[0] > right - 1 - left) {
                    answer[0] = left
                    answer[1] = right - 1
                }
                sum -= sequence[left++]
            } else if (sum > k) {
                sum -= sequence[left++]
            } else if (right < sequence.size) {
                sum += sequence[right++]
            } else {
                break
            }
        }

        return answer
    }
}

// 시간초과 난 코드 2
class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val dp = LongArray(sequence.size + 1) {0}

        var check = 0
        for (i in 1 until dp.size) {
            dp[i] = dp[i - 1] + sequence[i - 1]
            if (dp[i] < k) check = i
        }

        for (i in dp.size - 1 downTo check) {
            if (dp.contains(dp[i] - k)) {
                if (answer.isEmpty()) {
                    answer += dp.indexOfFirst { it == dp[i] - k }
                    answer += i
                } else {
                    if (answer[1] - answer[0] >= i - dp.indexOfFirst { it == dp[i] - k }) {
                        answer[0] = dp.indexOfFirst { it == dp[i] - k }
                        answer[1] = i
                    }
                }
            }
        }

        answer[1]--
        return answer
    }
}

// 시간초과 난 코드 1
class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val dp = LongArray(sequence.size + 1) {0}

        var check = 0
        for (i in 1 until dp.size) {
            dp[i] = dp[i - 1] + sequence[i - 1]
            if (dp[i] < k) check = i
        }

        for (i in dp.size - 1 downTo check) {
            for (j in 0 until i) {
                if ((dp[i] - dp[j]).toInt() == k) {
                    if (answer.isEmpty()) {
                        answer += j
                        answer += i
                    } else {
                        if (answer[1] - answer[0] >= i - j) {
                            answer[0] = j
                            answer[1] = i
                        }
                    }
                }
            }
        }

        answer[1]--
        return answer
    }
}
