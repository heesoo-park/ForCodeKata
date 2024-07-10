class Solution {
    fun solution(arr: IntArray): IntArray {
        // min() 함수를 인식하지 못해서 돌아간 풀이
        var answer = intArrayOf(-1)
        var minValue: Int = Int.MAX_VALUE

        if (arr.size == 1) {
            return answer
        } else {
            for (a in arr) {
                if (minValue > a) minValue = a
            }
            return arr.filter { it != minValue }.toIntArray()
        }
    }
}
