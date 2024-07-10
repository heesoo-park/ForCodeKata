class Solution {
    fun solution(numbers: IntArray): String {
        if (numbers.none { it != 0 }) return "0"
        val stringNumbers = numbers.map { it.toString() }
        val sortedNumbers = stringNumbers.sortedWith { n1, n2 ->
            (n2 + n1).compareTo(n1 + n2)
        }

        return sortedNumbers.fold("") { acc, num -> acc + num }
    }
}

// 케이스 3개 제외하고 모두 시간초과난 코드(하나는 런타임에러)
class Solution {
    var bigNum = ""
    fun solution(numbers: IntArray): String {
        val stringNumbers: MutableList<String> = numbers.map { it.toString() }.toMutableList()
        checkBigNum(stringNumbers, 0)

        return if (bigNum.toInt() == 0) "0" else bigNum
    }
    
    private fun checkBigNum(arr: MutableList<String>, depth: Int) {
        if (depth == arr.size) {
            val currentNum = arr.fold("") { acc, num -> acc + num}
            if (bigNum < currentNum) {
                bigNum = currentNum
                return
            }
        }

        for (i in depth until arr.size) {
            arr[i] = arr[depth].also { arr[depth] = arr[i] }
            checkBigNum(arr, depth + 1)
            arr[i] = arr[depth].also { arr[depth] = arr[i] }
        }
    }
}

// 간단하게 생각했다 케이스 2개만 맞은 코드..;;
class Solution {
    fun solution(numbers: IntArray): String {
        val stringNumbers = numbers.map { it.toString() }
        val sortedNumbers = stringNumbers.sortedWith(compareBy({it[0]}, {it.length})).reversed()
        
        return sortedNumbers.fold("") { acc, currentNumber -> acc + currentNumber}
    }
}
