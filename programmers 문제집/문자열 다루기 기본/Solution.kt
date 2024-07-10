class Solution {
    fun solution(s: String): Boolean {
        if (s.length == 4 || s.length == 6) return !s.contains(Regex("[a-zA-Z]"))
        else return false
    }
}
