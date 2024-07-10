class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        var end: Int = phone_number.length - 4

        for (i in 0 until end) {
            answer += "*"
        }
        answer += phone_number.substring(end until phone_number.length)
        return answer
    }
}
