class Solution {
    fun solution(s: String): String {
        var len: Int = s.length
        return if (len % 2 != 0) s.substring(len / 2, len / 2 + 1) else s.substring(len / 2 - 1, len / 2 + 1)
    }
}
