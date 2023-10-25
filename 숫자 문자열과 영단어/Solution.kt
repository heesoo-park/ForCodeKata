class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var numMap: Map<String, Int> = mapOf<String, Int>(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,)

        var str = ""
        for (i in s.indices) {
            str += s[i]

            if (str[0].isDigit()) {
                answer *= 10
                answer += str.toInt()
                str = ""
            } else {
                if (numMap.containsKey(str)) {
                    answer *= 10
                    answer += numMap[str]!!.toInt()
                    str = ""
                }
            }
        }

        return answer
    }
}
