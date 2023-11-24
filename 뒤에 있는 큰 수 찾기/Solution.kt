import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size)
        var stack: Stack<Pair<Int, Int>> = Stack()

        for ((index, item) in numbers.withIndex()) {
            if (stack.isEmpty()) {
                stack.push(Pair(index, item))
                continue
            }

            while (stack.isNotEmpty() && item > stack.peek().second) {
                val popValue = stack.pop()
                answer[popValue.first] = item
            }
            stack.push(Pair(index, item))
        }

        while (stack.isNotEmpty()) {
            val popValue = stack.pop()
            answer[popValue.first] = -1
        }
        
        return answer
    }
}

// 절반만 통과한 코드(시간초과)
class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var copyNumbers: IntArray = intArrayOf()

        numbers.forEach {
            copyNumbers += it
        }

        for (idx in numbers.size - 1 downTo 0) {
            if (idx == numbers.size - 1) {
                answer += -1
            } else {
                if (numbers[idx] < numbers[idx + 1]) {
                    answer += numbers[idx + 1]
                    copyNumbers[idx] = numbers[idx + 1]
                } else {
                    if (numbers[idx] < copyNumbers[idx + 1]) {
                        answer += copyNumbers[idx + 1]
                        copyNumbers[idx] = copyNumbers[idx + 1]
                    } else {
                        for (i in idx + 1 until numbers.size) {
                            if (numbers[idx] < numbers[i]) {
                                answer += numbers[i]
                                copyNumbers[idx] = numbers[i]
                                break
                            } else {
                                if (numbers[idx] < copyNumbers[i]) {
                                    answer += copyNumbers[i]
                                    copyNumbers[idx] = copyNumbers[i]
                                    break
                                }
                            }

                            if (i == numbers.size - 1) answer += -1
                        }
                    }
                }
            }
        }

        return answer.reversedArray()
    }
}

// 예제만 통과했던 코드
class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var copyNumbers: IntArray = intArrayOf()

        numbers.forEach {
            copyNumbers += it
        }

        for (idx in numbers.size - 1 downTo 0) {
            if (idx == numbers.size - 1) {
                answer += -1
            } else {
                if (numbers[idx] < numbers[idx + 1]) {
                    answer += numbers[idx + 1]
                    copyNumbers[idx] = numbers[idx + 1]
                } else {
                    if (numbers[idx] < copyNumbers[idx + 1]) {
                        answer += copyNumbers[idx + 1]
                        copyNumbers[idx] = copyNumbers[idx + 1]
                    } else {
                        answer += -1
                    }
                }
            }
        }

        return answer.reversedArray()
    }
}
