class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var emptyBottle = n

        while (emptyBottle / a != 0) {
            var curGetBottle = emptyBottle / a * b
            emptyBottle = curGetBottle + emptyBottle % a

            answer += curGetBottle
        }

        return answer
    }
}
