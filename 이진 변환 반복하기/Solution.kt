class Solution {
    fun solution(s: String): IntArray {
                var answer: IntArray = intArrayOf(0, 0)
        var temp = s

        while (temp != "1") {
            answer[1] += temp.count { it == '0' }
            temp = temp.filter { it != '0' }.length.toString(2)
            answer[0]++
        }

        return answer
    }
}
