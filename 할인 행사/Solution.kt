class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val requiredDay = number.sumOf { it }
        val totalDiscountDay = discount.size

        for (day in 0..totalDiscountDay - requiredDay) {
            var categoryAndAmount: Map<String, Int> = discount.sliceArray(day until day + requiredDay).groupingBy { it }.eachCount()

            var count = 0
            for (itemIdx in 0 until want.size) {
                val curItem = want[itemIdx]
                if (categoryAndAmount.containsKey(curItem) && categoryAndAmount[curItem]!! >= number[itemIdx]) count++
                else break
            }

            if (count == number.size) answer++
        }

        return answer
    }
}
