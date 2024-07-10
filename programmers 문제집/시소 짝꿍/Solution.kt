class Solution {
    private var answer: Long = 0
    fun solution(weights: IntArray): Long {
        var weightsGroup = weights.toList().groupingBy { it }.eachCount()

        for (weight in weightsGroup) {
            if (weight.value >= 2) {
                answer += weight.value.toLong() * (weight.value.toLong() - 1) / 2
            }

            checkWeight(weightsGroup, weight.key, 2.0 / 3.0)
            checkWeight(weightsGroup, weight.key, 2.0 / 4.0)
            checkWeight(weightsGroup, weight.key, 3.0 / 4.0)
        }

        return answer
    }

    private fun checkWeight(w: Map<Int, Int>, key: Int, ratio: Double) {
        if ((key * ratio) - (key * ratio).toInt() == 0.0 && w.containsKey((key * ratio).toInt())) answer += (w[(key * ratio).toInt()]!!.toLong() * w[key]!!.toLong())
    }
}

// 형변환을 통해 전보다 덜 틀린 코드
class Solution {
    private var answer: Long = 0
    fun solution(weights: IntArray): Long {
        var weightsGroup = weights.toList().groupingBy { it }.eachCount()

        for (weight in weightsGroup) {
            if (weight.value >= 2) {
                answer += weight.value.toLong() * (weight.value.toLong() - 1) / 2
            }

            checkWeight(weightsGroup, weight.key, 2, 3)
            checkWeight(weightsGroup, weight.key, 2, 4)
            checkWeight(weightsGroup, weight.key, 3, 4)
        }

        return answer
    }

    private fun checkWeight(w: Map<Int, Int>, key: Int, ratio1: Int, ratio2: Int) {
        if (w.containsKey(key * ratio1 / ratio2)) answer += (w[key * ratio1 / ratio2]!!.toLong() * w[key]!!.toLong())
    }
}

// 전보다는 조금 덜 틀린 코드
class Solution {
    private var answer: Long = 0
    fun solution(weights: IntArray): Long {
        var weightsGroup = weights.toList().groupingBy { it }.eachCount()

        for (weight in weightsGroup) {
            if (weight.value >= 2) {
                answer += weight.value * (weight.value - 1) / 2
            }

            checkWeight(weightsGroup, weight.key, 2, 3)
            checkWeight(weightsGroup, weight.key, 2, 4)
            checkWeight(weightsGroup, weight.key, 3, 4)
        }

        return answer
    }

    private fun checkWeight(w: Map<Int, Int>, key: Int, ratio1: Int, ratio2: Int) {
        if (w.containsKey(key * ratio1 / ratio2)) answer += (w[key * ratio1 / ratio2]!! * w[key]!!)
    }
}

// 많이 틀린 코드
class Solution {
    private val allWeights: LongArray = LongArray(4001) { 0 }
    private var answer: Long = 0
    fun solution(weights: IntArray): Long {
        var userNum = mutableSetOf<Int>()
        for (weight in weights) {
            checkWeight(weight, 2)
            checkWeight(weight, 3)
            checkWeight(weight, 4)

            if (userNum.contains(weight)) answer -= 2

            userNum.add(weight)
        }
        return answer
    }

    private fun checkWeight(w: Int, len: Int) {
        allWeights[w * len]++
        if (allWeights[w * len] > 1) {
            answer += (allWeights[w * len] - 1)
        }
    }
}

// 메모리 초과난 코드
class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        val partners = combination(weights.toList(), weights.size, 2)
        val checkList = listOf(2, 6, 12)
        
        partners.forEach {
            if (it[0] == it[1]) {
                answer++
            } else {
                val lcm = it[0] / gcd(it[0], it[1]) * it[1] / gcd(it[0], it[1])
                if (checkList.contains(lcm)) answer++
            }
        }

        return answer
    }

    private fun <T> combination(array: List<T>, n: Int, r: Int): List<List<T>> {
        val result = mutableListOf<List<T>>()

        fun recursive(depth: Int, idx: Int, temp: MutableList<T> = mutableListOf()) {
            if (depth == r) {
                result.add(temp.toList())
                return
            }

            for (i in idx until n) {
                temp.add(array[i])
                recursive(depth + 1, i + 1, temp)
                temp.removeAt(temp.lastIndex)
            }
        }

        recursive(0, 0)
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var temp: Int
        val numArr = arrayOf(a, b)

        while (numArr[1] != 0) {
            temp = numArr[0] % numArr[1]
            numArr[0] = numArr[1]
            numArr[1] = temp
        }

        return numArr[0]
    }
}
