class Solution {
    fun solution(X: String, Y: String): String {
        var answer = StringBuilder()
        var countX = Array<Int>(10) {0}
        var countY = Array<Int>(10) {0}
        var minCountXY = Array<Int>(10) {0}

        for (i in X) {
            countX[i - '0']++
        }
        for (i in Y) {
            countY[i - '0']++
        }
        for (num in 0..9) {
            if (countX[num] != 0 && countY[num] != 0) {
                if (countX[num] >= countY[num]) minCountXY[num] = countY[num]
                else minCountXY[num] = countX[num]
            }
        }

        for (num in 9 downTo 0) {
            for (i in 0 until minCountXY[num]) {
                answer.append(num)
            }
        }

        if (answer.isNotEmpty()) {
            if (minCountXY[0] == answer.length) return "0"
            return answer.toString()
        } else {
            return "-1"
        }
    }
}
