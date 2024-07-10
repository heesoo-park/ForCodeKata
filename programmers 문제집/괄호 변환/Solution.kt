// StringBuilder로 풀이한 코드
import java.util.Stack

class Solution {
    fun solution(p: String): String {
        return if (checkCorrect(p)) p else solve(p)
    }
    
    fun solve(w: String): String {
        if (w == "") return ""

        val u = StringBuilder()
        val v = StringBuilder()
        var isFull = false
        val count = arrayOf(0, 0)
        w.forEach {
            if (!isFull) u.append(it)
            else v.append(it)

            if (it == '(') count[0]++
            else if (it == ')') count[1]++

            if (count[0] == count[1]) isFull = true
        }

        return if (checkCorrect(u.toString())) {
            u.toString() + solve(v.toString())
        } else {
            u.deleteCharAt(0)
            u.deleteCharAt(u.lastIndex)
            u.forEachIndexed { index, it ->
                if (it == '(') u.replace(index, index + 1, ")")
                else if (it == ')') u.replace(index, index + 1, "(")
            }

            "(" + solve(v.toString()) + ")" + u.toString()
        }
    }

    private fun checkCorrect(s: String): Boolean {
        val stack = Stack<Char>()

        s.forEach {
            if (it == '(') {
                stack.push(it)
            }
            else {
                if (stack.isNotEmpty()) stack.pop()
            }
        }

        return stack.isEmpty()
    }
}

// 문자열로 풀이한 코드
import java.util.Stack

class Solution {
    fun solution(p: String): String {
        return if (checkCorrect(p)) p else solve(p)
    }

    private fun solve(w: String): String {
        if (w == "") return ""

        var u = ""
        var v = ""
        var isFull = false
        val count = arrayOf(0, 0)
        w.forEach {
            if (!isFull) u += it
            else v += it

            if (it == '(') count[0]++
            else if (it == ')') count[1]++

            if (count[0] == count[1]) isFull = true
        }

        return if (checkCorrect(u)) {
            u + solve(v)
        } else {
            var temp = u.substring(1 until u.lastIndex).toCharArray()
            temp.forEachIndexed { index, c ->
                if (c == '(') temp[index] = ')'
                else if (c == ')') temp[index] = '('
            }
            u = temp.joinToString("")

            "(" + solve(v) + ")" + u
        }
    }

    private fun checkCorrect(s: String): Boolean {
        val stack = Stack<Char>()

        s.forEach {
            if (it == '(') {
                stack.push(it)
            }
            else {
                if (stack.isNotEmpty()) stack.pop()
            }
        }

        return stack.isEmpty()
    }
}
