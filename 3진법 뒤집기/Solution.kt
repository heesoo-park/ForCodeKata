import kotlin.math.*

class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var num: Int = n
        var arr = arrayOf<Int>()

        while (num != 0) {
            arr += num % 3
            num /= 3
        }

        for (i in arr.size - 1 downTo 0) {
            answer += (arr[arr.size - 1 - i] * (3.0).pow(i)).toInt()
        }

        // return arr.foldIndexed(0) {idx, ans, num -> ans + (num * (3.0).pow(arr.size - 1 - idx)).toInt()}

        return answer
    }
}
