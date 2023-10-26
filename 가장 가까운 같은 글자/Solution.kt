class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var position = Array(26) { -1 }

        for (i in s.indices) {
            if (position[s[i] - 'a'] == -1) answer += -1
            else answer += (i - position[s[i] - 'a'])

            position[s[i] - 'a'] = i
        }
        return answer
    }
}
