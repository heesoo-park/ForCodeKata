class Solution {
    val height = arrayListOf<Int>()
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        var answer: DoubleArray = doubleArrayOf()


        val num = calHailstone(k, 0)
        val areas = Array(num) { 0.0 }

        for (i in 0 until num) {
            areas[i] = (height[i] + height[i + 1]) / 2.0
        }

        ranges.forEach {
            answer += when {
                it[0] > num + it[1] -> {
                    -1.0
                }

                it[0] == num + it[1] -> {
                    0.0
                }

                else -> {
                    areas.sliceArray(it[0] until num + it[1]).sum()
                }
            }
        }

        return answer
    }

    private fun calHailstone(n: Int, count: Int): Int {
        height.add(n)
        return when {
            n == 1 -> {
                count
            }
            n % 2 == 0 -> {
                calHailstone(n / 2, count + 1)
            }
            else -> {
                calHailstone(n * 3 + 1, count + 1)
            }
        }
    }
}
