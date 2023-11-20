class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer: Int
        var clothesType = mutableMapOf<String, Int>()

        for (i in clothes) {
            clothesType[i[1]] = clothesType.getOrDefault(i[1], 1) + 1
        }

        answer = clothesType.values.fold(1) {
            acc, value -> acc * value
        }

        return answer - 1
    }
}
