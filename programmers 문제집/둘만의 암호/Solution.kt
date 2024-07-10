class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""
        var alphabet: String = "abcdefghijklmnopqrstuvwxyz"

        for (c in skip) {
            alphabet = alphabet.replace(c.toString(), "")
        }

        for (c in s) {
            answer += alphabet[(alphabet.indexOf(c) + index) % alphabet.length]
        }

        return answer
    }
}
