class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        return a.foldIndexed(0) {idx, ans, num -> ans + num * b[idx]}
    }
}
