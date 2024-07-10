class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var sortedList = strings.sortedWith(compareBy({ it[n] }, { it }))

        return sortedList.toTypedArray()
    }
}
