class Solution {
    var answer: IntArray = IntArray(2) {0}
    
    fun solution(arr: Array<IntArray>): IntArray {
        dfs(arr, 0, 0, arr.size)

        return answer
    }
    
        private fun dfs(arr: Array<IntArray>, row: Int, col: Int, size: Int) {
        if (size == 1) {
            if (arr[row][col] == 1) answer[1]++
            else answer[0]++

            return
        }

        val start = arr[row][col]
        var count = 0
        for (i in row until row + size) {
            for (j in col until col + size) {
                if (start == arr[i][j]) count++
            }
        }

        if (count == size * size) {
            if (start == 1) answer[1]++
            else answer[0]++

            return
        }

        dfs(arr, row, col, size / 2)
        dfs(arr, row, col + size / 2, size / 2)
        dfs(arr, row + size / 2, col, size / 2)
        dfs(arr, row + size / 2, col + size / 2, size / 2)
    }
}

// 테스트케이스는 다 맞아서 냈더니 2개 맞은 코드
import kotlin.math.*

class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        var answer: IntArray = IntArray(2) {0}
        val compression = Array<IntArray>(arr.size) { IntArray(arr.size) {1} }

        if (arr.size == 1) {
            if (arr[0][0] == 1) answer[1]++
            else answer[0]++

            return answer
        }
        
        val base = 2.0
        for (round in 1..log2(arr.size.toDouble()).toInt()) {
            for (i in base.pow(round).toInt() - 1 until arr.size step 2 * round) {
                for (j in base.pow(round).toInt() - 1 until arr.size step 2 * round) {

                    if (arr[i][j] == arr[i - base.pow(round - 1).toInt()][j]
                        && arr[i - base.pow(round - 1).toInt()][j] == arr[i - base.pow(round - 1).toInt()][j - base.pow(round - 1).toInt()]
                        && arr[i - base.pow(round - 1).toInt()][j - base.pow(round - 1).toInt()] == arr[i][j - base.pow(round - 1).toInt()]) {

                        if (compression[i][j] == compression[i - base.pow(round - 1).toInt()][j]
                            && compression[i - base.pow(round - 1).toInt()][j] == compression[i - base.pow(round - 1).toInt()][j - base.pow(round - 1).toInt()]
                            && compression[i - base.pow(round - 1).toInt()][j - base.pow(round - 1).toInt()] == compression[i][j - base.pow(round - 1).toInt()]) {

                            compression[i][j] *= 4
                            compression[i - base.pow(round - 1).toInt()][j] = 1
                            compression[i - base.pow(round - 1).toInt()][j - base.pow(round - 1).toInt()] = 1
                            compression[i][j - base.pow(round - 1).toInt()] = 1
                        }
                    }
                }
            }
        }

        for (i in arr.indices) {
            for (j in arr.indices) {
                when (arr[i][j]) {
                    0 -> {
                        if (compression[i][j] != 1) {
                            answer[0] = answer[0] - compression[i][j] + 2
                        } else {
                            answer[0]++
                        }
                    }
                    1 -> {
                        if (compression[i][j] != 1) {
                            answer[1] = answer[1] - compression[i][j] + 2
                        } else {
                            answer[1]++
                        }
                    }
                }
            }
        }
        return answer
    }
}
