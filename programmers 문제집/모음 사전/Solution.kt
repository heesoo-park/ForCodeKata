class Solution {
    private var count = 0
    private var answer = 0
    fun solution(word: String): Int {
        var lists = listOf('A', 'E', 'I', 'O', 'U')

        dfs(word, lists, "")

        return answer
    }

    private fun dfs(word: String, lists: List<Char>, cur: String) {
        if (cur == word) {
            answer = count
            return
        }
        if (cur.length == 5) {
            return
        }

        for (i in 0..4) {
            count++
            dfs(word, lists, cur + lists[i])
        }
    }
}
