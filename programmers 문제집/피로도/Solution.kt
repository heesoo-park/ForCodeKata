class Solution {
    var max = 0
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        checkPermination(dungeons, 0, dungeons.size, dungeons.size, k)

        return max
    }
    
    private fun checkPermination(arr: Array<IntArray>, depth: Int, n: Int, pick: Int, value: Int) {
        if (depth == pick) {
            var tired = value
            var clear = 0
            for (i in arr) {
                if (tired < i[0]) break
                else {
                    tired -= i[1]
                    clear++
                }
            }
            max = max.coerceAtLeast(clear)
            return
        }

        for (i in depth until n) {
            arr[i] = arr[depth].also { arr[depth] = arr[i] }
            checkPermination(arr, depth + 1, n, pick, value)
            arr[i] = arr[depth].also { arr[depth] = arr[i] }
        }
    }
}
