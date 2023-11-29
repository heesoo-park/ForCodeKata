// 문자열을 이용한 코드
class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer: LongArray = longArrayOf()

        for (num in numbers) {
            if (num % 2 == 0L) {
                answer += (num + 1)
            }
            else {
                var str = '0' + num.toString(2)
                var idx = str.length - 1
                while (true) {
                    if (str[idx - 1] == '0' && str[idx] == '1') break

                    idx--
                }
                val changeStr = str.substring(0 until idx - 1) + "10" + str.substring(idx + 1 until str.length)
                answer += changeStr.toLong(2)
            }
        }

        return answer
    }
}

// StringBuilder를 이용한 코드
class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer: LongArray = longArrayOf()

        for (num in numbers) {
            if (num % 2 == 0L) {
                answer += (num + 1)
            }
            else {
                var str = StringBuilder('0' + num.toString(2))
                var idx = str.length - 1
                while (true) {
                    if (str[idx - 1] == '0' && str[idx] == '1') break

                    idx--
                }
                
                str.setCharAt(idx - 1, '1')
                str.setCharAt(idx, '0')
                answer += str.toString().toLong(2)
            }
        }

        return answer
    }
}

// 마지막 두 개의 케이스 시간초과난 코드
class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer: LongArray = longArrayOf()

        for (num in numbers) {
            var current = num + 1
            while (true) {
                if ((num xor current).toString(2).count { it == '1' } <= 2) {
                    answer += current
                    break
                }

                current++
            }
        }

        return answer
    }
}
