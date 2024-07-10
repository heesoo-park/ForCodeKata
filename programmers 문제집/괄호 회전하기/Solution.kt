// 성공한 코드
import java.util.Stack

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val len = s.length
        val stack = Stack<Char>()

        for (i in 0 until len) {
            var mathces: Int = 0
            for (idx in s.indices) {
                var curIdx = (idx + i) % len
                if (s[curIdx] == '[' || s[curIdx] == '(' || s[curIdx] == '{') {
                    stack.push(s[curIdx])
                }
                else {
                    if (stack.isNotEmpty()) {
                        if (s[curIdx] == ']' && stack.peek() == '[') {
                            stack.pop()
                            mathces++
                        }
                        else if (s[curIdx] == ')' && stack.peek() == '(') {
                            stack.pop()
                            mathces++
                        }
                        else if (s[curIdx] == '}' && stack.peek() == '{') {
                            stack.pop()
                            mathces++
                        }
                    }
                }
            }

            if (stack.isEmpty() && mathces * 2 == s.length) answer++
            else stack.clear()
        }

        return answer
    }
}

// 실패한 코드
class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val len = s.length
        val stack = Stack<Char>()

        for (i in 0 until len) {
            for (idx in s.indices) {
                var curIdx = (idx + i) % len
                if (s[curIdx] == '[' || s[curIdx] == '(' || s[curIdx] == '{') {
                    stack.push(s[curIdx])
                }
                else {
                    if (stack.isNotEmpty()) {
                        if (s[curIdx] == ']' && stack.peek() == '[') stack.pop()
                        else if (s[curIdx] == ')' && stack.peek() == '(') stack.pop()
                        else if (s[curIdx] == '}' && stack.peek() == '{') stack.pop()
                    }
                }
            }

            if (stack.isEmpty()) answer++
            else stack.clear()
        }

        return answer
    }
}
