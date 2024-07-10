class Solution {
    fun solution(n: Int, m: Int): IntArray {
        var answer = intArrayOf()

        answer += gcd(n, m)
        answer += (n * m / gcd(n, m))
        
        return answer
    }
    
    fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        else return gcd(b, a%b)
    }
}
