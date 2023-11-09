class Solution {
    fun solution(s: String): String {
        var answer = StringBuilder()
        val list = s.split(" ")

        list.forEach {
            it.forEachIndexed { index, c ->
                answer.append(if (index == 0) c.uppercase() else c.lowercase())
            }
            answer.append(" ")
        }

        answer.deleteCharAt(answer.lastIndex)
        return answer.toString()
    }
}
