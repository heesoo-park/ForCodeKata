class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        var orders = arrayListOf<Int>()

        for (item in ingredient) {
            orders.add(item)
            val size = orders.size
            if (size >= 4) {
                if (orders[size - 4] == 1 && orders[size - 3] == 2 && orders[size - 2] == 3 && orders[size - 1] == 1) {
                    answer++
                    for (i in size - 1 downTo size - 4) {
                        orders.removeAt(i)
                    }
                }
            }
        }

        return answer
    }
}
