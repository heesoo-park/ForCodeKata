class Solution {
    fun solution(babbling: Array<String>): Int {
       var answer: Int = 0
        val wordList = arrayListOf("aya", "ye", "woo", "ma")
        
        for (item in babbling) {
            var temp = item
            for ((index, word) in wordList.withIndex()) {
                if (temp.contains(word)) temp = temp.replace(word, index.toString())
            }

            if (temp.filter { it.isDigit() }.length == temp.length) {
                answer++
                for (i in 0 until temp.length - 1) {
                    if (temp[i] == temp[i + 1]) {
                        answer--
                        break
                    }
                }
            }
        }

        return answer
    }
}
