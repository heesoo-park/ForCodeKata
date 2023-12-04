class Solution {
    val number = StringBuilder("")
    val numberSet = mutableSetOf<Int>()
    var answer = 0
    
    fun solution(numbers: String): Int {
        val numbersPair = numbers.map { Pair2(it, false) }

        selectNumber(numbersPair)

        return answer
    }
    
    private fun selectNumber(numbersPair: List<Pair2>) {
        if (number.isNotEmpty()) {
            checkPrimeNumber(number.toString().toInt())
            numberSet.add(number.toString().toInt())
        }

        for (i in numbersPair.indices) {
            if (!numbersPair[i].second) {
                numbersPair[i].second = true
                number.append(numbersPair[i].first)
                selectNumber(numbersPair)
                number.deleteCharAt(number.length - 1)
                numbersPair[i].second = false
            }
        }
    }

    private fun checkPrimeNumber(num: Int) {
        if (num <= 1 || numberSet.contains(num)) return

        for (i in 2..num / 2) {
            if (num % i == 0) return
        }
        answer++
    }

    data class Pair2(var first: Char, var second: Boolean)
}
