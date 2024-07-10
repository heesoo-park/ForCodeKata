class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var temp = sizes

        for (i in sizes.indices) {
            if (temp[i][0] < temp[i][1]) {
                temp[i][0] = temp[i][1].also { temp[i][1] = temp[i][0] }
            }
        }

        var max1 = 0
        var max2 = 0
        for (i in sizes.indices) {
            if (max1 < temp[i][0]) max1 = temp[i][0]
            if (max2 < temp[i][1]) max2 = temp[i][1]
        }

        return max1 * max2
    }
}
