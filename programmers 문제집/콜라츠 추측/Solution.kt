class Solution {
    fun solution(num: Int): Int {
        var tmp: Long = num.toLong()
        var answer = 0
        
        if (tmp == 1L) return 0
        
        while (tmp != 1L && answer != 500) {
            if (tmp % 2 == 0L) tmp /= 2
            else tmp = tmp * 3 + 1
            
            answer++
        }
        
        return if (tmp == 1L) answer else -1
    }
}
