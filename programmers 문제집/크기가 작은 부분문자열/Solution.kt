class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0

        for (i in 0 until t.length - p.length + 1) {
            if (t.substring(i, i + p.length).toLong() <= p.toLong()) answer++
        }

        return answer
    }
}
