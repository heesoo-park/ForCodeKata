class Solution {
    fun solution(elements: IntArray): Int {
        val sumSet = mutableSetOf<Int>()

        for (i in elements.indices) {
            var sum = 0
            for (j in elements.indices) {
                val curIdx = (i + j) % elements.size
                sum += elements[curIdx]
                sumSet += sum
            }
        }

        return sumSet.size
    }
}
