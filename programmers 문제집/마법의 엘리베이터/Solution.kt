class Solution {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        var cur = storey

        while (cur != 0) {
            if (cur % 10 == 5) {
                if (cur / 10 % 10 >= 5) {
                    answer += 5
                    cur += 10
                } else {
                    answer += 5
                    // cur -= 5
                }
            } else if (cur % 10 < 5) {
                answer += cur % 10
                // cur -= cur % 10
            } else if (cur % 10 > 5) {
                answer += (10 - cur % 10)
                cur += 10
                // cur += (10 - cur % 10)
            }

            cur /= 10
        }

        return answer
    }
}
