class Solution {
    fun solution(arr: IntArray): Int {
        for (i in 0 until arr.size - 1) {
            arr[i + 1] = (arr[i] * arr[i + 1]) / gcd(arr[i], arr[i + 1])
        }

        return arr[arr.size - 1]
    }
    
    private fun gcd(a: Int, b: Int): Int {
        var temp: Int
        var A = a
        var B = b
        while (B != 0) {
            temp = A % B
            A = B
            B = temp
        }

        return A
    }
}
