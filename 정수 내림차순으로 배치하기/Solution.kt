class Solution {
    fun solution(n: Long): Long {
        var str: String = n.toString()

        return String(str.toCharArray().sortedArrayDescending()).toLong()
    }
}
