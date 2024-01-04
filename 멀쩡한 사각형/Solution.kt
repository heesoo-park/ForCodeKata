class Solution {
    fun solution(w: Int, h: Int): Long {
        var longW = w.toLong()
        var longH = h.toLong()
        var gcd = gcd(longW, longH)

        // 전체 정사각형 개수 - (패턴이 반복되는 사각형 속의 멀쩡하지 않은 사각형 개수) * 패턴 반복 횟수
        // longW * longH - (longW / gcd * longH / gcd - (longW / gcd - 1) * (longH / gcd - 1)) * gcd
        return longW * longH - (longW + longH - gcd)
    }

    private fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
}
