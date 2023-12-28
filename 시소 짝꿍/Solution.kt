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
