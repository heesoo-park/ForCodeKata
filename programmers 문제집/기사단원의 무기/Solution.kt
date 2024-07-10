import kotlin.math.*

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        val knightsPower = Array<Int>(number + 1) {0}

        for (i in 1..number) {
            for (j in 1..sqrt(i.toDouble()).toInt()) {
                if (i % j == 0) {
                    if (j * j != i) knightsPower[i] += 2
                    else knightsPower[i]++
                }
            }
        }

        return knightsPower.foldIndexed(0) { _, acc, value -> acc + if (value <= limit) value else power }
    }
}
