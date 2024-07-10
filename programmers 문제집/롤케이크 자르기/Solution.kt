class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        var onePiece = IntArray(topping.size) {0}
        var anotherPiece = IntArray(topping.size) {0}
        var oneToppingCount = mutableSetOf<Int>()
        var anotherToppingCount = mutableSetOf<Int>()

        for (i in topping.indices) {
            oneToppingCount.add(topping[i])
            onePiece[i] = oneToppingCount.size
            anotherToppingCount.add(topping[topping.size - 1 - i])
            anotherPiece[i] = anotherToppingCount.size
        }

        for (i in 0 until topping.size - 1) {
            if (onePiece[i] == anotherPiece[topping.size - 2 - i]) answer++
        }

        return answer
    }
}

// 통과할 줄 알았지만 실패한 코드(시간초과)
class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        var onePiece = intArrayOf()
        var anotherPiece = intArrayOf()
        var oneToppingCount = mutableSetOf<Int>()
        var anotherToppingCount = mutableSetOf<Int>()

        for (i in topping.indices) {
            oneToppingCount.add(topping[i])
            onePiece += oneToppingCount.size
            anotherToppingCount.add(topping[topping.size - 1 - i])
            anotherPiece += anotherToppingCount.size
        }

        for (i in 0 until topping.size - 1) {
            if (onePiece[i] == anotherPiece[topping.size - 2 - i]) answer++
        }

        return answer
    }
}

// 안 될 걸 알았지만 짠 코드(시간초과)
class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        for (i in topping.indices) {
            val onePiece = topping.sliceArray(0..i).toMutableSet()
            val anotherPiece = topping.sliceArray(i + 1 until topping.size).toMutableSet()

            if (onePiece.size == anotherPiece.size) answer++
        }

        return answer
    }
}
