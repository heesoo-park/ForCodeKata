class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0

        var list = n.toString(k).split("0+".toRegex()).toMutableList()
        list.removeIf { it == "" }

        list.forEach {
            if (checkPrimeNumbers(it.toLong())) answer++
        }

        return answer
    }
    
    private fun checkPrimeNumbers(num: Long): Boolean {
        if (num == 1L) return false

        var i = 2L

        while (i * i <= num) {
            if (num % i++ == 0L) return false
        }
        return true
    }
}

// 쓰려다가 쓰지 않은 에라토스테네스의 체 알고리즘
private fun getPrimeNumbers(): List<Int> {
        var list = mutableListOf<Int>()
        var arr = IntArray(101) { 0 }

        for (i in 2..100) {
            arr[i] = i
        }

        for (i in 2..100) {
            if (arr[i] == 0) continue

            for (j in 2 * i..100 step i) {
                arr[j] = 0
            }
        }

        for (i in 2..100) {
            if (arr[i] != 0) list += arr[i]
        }

        return list
    }
