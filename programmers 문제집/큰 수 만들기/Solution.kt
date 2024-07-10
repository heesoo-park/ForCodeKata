class Solution {
    fun solution(number: String, k: Int): String {
        var strNum = ArrayDeque<Char>()

        var count = 0
        for (n in number) {
            while (strNum.isNotEmpty() && strNum.last() < n) {
                if (count == k) break
                strNum.removeLast()
                count++
            }
            strNum.add(n)
        }

        for (i in 0 until k - count) {
            strNum.removeLast()
        }

        return strNum.joinToString("")
    }
}

// 시간초과가 난 코드(아래 코드보다는 조금 더 빠름)
class Solution {
    var answer = ""
    fun solution(number: String, k: Int): String {
        findNum(number, 1, k)

        return answer
    }

    private fun findNum(n: String, i: Int, k: Int) {
        var strNum = StringBuilder(n)
        for (idx in n.indices) {
            val deleteChar = strNum[idx]
            if (strNum.deleteCharAt(idx).toString() > answer) {
                answer = strNum.toString()
            }
            strNum.insert(idx, deleteChar)
        }

        if (i < k) {
            findNum(answer.also { answer = "" }, i + 1, k)
        }
    }
}

// 시간초과가 난 코드
class Solution {
    var answer = ""
    fun solution(number: String, k: Int): String {
        findNum(number, 1, k)

        return answer
    }

    private fun findNum(n: String, i: Int, k: Int) {
        for (idx in n.indices) {
            var strNum = StringBuilder(n)
            if (strNum.deleteCharAt(idx).toString() > answer) {
                answer = strNum.toString()
            }
        }

        if (i < k) {
            findNum(answer.also { answer = "" }, i + 1, k)
        }
    }
}

// 런타임 에러 폭탄맞은코드
class Solution {
    var answer = ""
    fun solution(number: String, k: Int): String {
        findNum(number, 1, k)

        return answer
    }

    private fun findNum(n: String, i: Int, k: Int) {
        for (idx in n.indices) {
            var strNum = StringBuilder(n)
            if (strNum.deleteCharAt(idx).toString().toLong() > (answer.toLongOrNull() ?: -1)) {
                answer = strNum.toString()
            }
        }

        if (i < k) {
            findNum(answer.also { answer = "" }, i + 1, k)
        }
    }
}

