class Solution {
    fun solution(a: Int, b: Int): String {
        var answer = ""
        var day = 0
        val dayOfMonth = mapOf<Int, Int>(1 to 31, 2 to 29, 3 to 31, 4 to 30, 5 to 31, 6 to 30, 7 to 31, 8 to 31, 9 to 30, 10 to 31, 11 to 30, 12 to 31)
        val nameOfDay = mapOf<Int, String>(1 to "FRI", 2 to "SAT", 3 to "SUN", 4 to "MON", 5 to "TUE", 6 to "WED", 0 to "THU")

        for (i in 1 until a) {
            day += dayOfMonth[i]!!
        }
        day += b
        answer += nameOfDay[day % 7]

        return answer
    }
}
