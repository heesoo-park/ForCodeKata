class Solution {
    fun solution(s: String): String {
        val list = s.split(" ").sorted()

        return "${list.first()} ${list.last()}"
    }
}
