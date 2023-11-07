class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var dic = mutableMapOf<Char, Int>()
        for (item in terms) {
            dic[item[0]] = item.slice(2 until item.length).toInt()
        }

        var todayCount = calCount(today)

        for ((index, info) in privacies.withIndex()) {
            var count = calCount(info)

            var expirationPeriod = dic[info[11]]!! * 28
            if (todayCount >= count + expirationPeriod) answer += (index + 1)
        }
        return answer
    }

    private fun calCount(Date: String): Int {
        var sum = 0
        sum += (Date.slice(0..3).toInt() - 2000) * 12 * 28
        sum += Date.slice(5..6).toInt() * 28
        sum += Date.slice(8..9).toInt()

        return sum
    }
}
