// 너무 어렵게 생각하고 풀었다
// 문자열로 바꿔볼 생각도 못 하고 map이나 filter도 써본적이 없어서 많이 돌아간 거 같다
class Solution {
    fun solution(n: Long): IntArray {
        val List = mutableListOf<Int>()
        var N: Long = n
        
        while (N != 0L) {
            List.add((N % 10).toInt())
            N /= 10
        }
        
        var answer = IntArray(List.size)
        for (i in 0..List.size - 1) {
            answer[i] = List[i]
        }
        
        return answer
    }
}
