import kotlin.math.sqrt

class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0

        val useD: Long = d.toLong()
        val useK: Long = k.toLong()
        for (i in 0..useD step useK) {
            answer += (sqrt(((useD * useD - i * i).toDouble())) / useK).toLong() + 1
        }

        return answer
    }
}
