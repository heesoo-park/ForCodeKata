class Solution {
    private val statistics = Array(50) { Array(50) { 0 } }
    private val giftIndex = Array(50) { Array(2) { 0 } }
    private val nextGift = Array(50) { 0 }
    private val mapper: HashMap<String, Int> = hashMapOf()
    fun solution(friends: Array<String>, gifts: Array<String>): Int {

        friends.forEachIndexed { index, friend ->
            mapper[friend] = index
        }

        gifts.forEach { gift ->
            gift.split(" ").let {
                val giftGiver = mapper[it[0]] ?: 0
                val giftTaker = mapper[it[1]] ?: 0
                statistics[giftGiver][giftTaker]++
                giftIndex[giftGiver][0]++
                giftIndex[giftTaker][1]++
            }
        }

        for (i in friends.indices) {
            for (j in i + 1 until friends.size) {
                if (statistics[i][j] > statistics[j][i]) {
                    nextGift[i]++
                } else if (statistics[i][j] < statistics[j][i]) {
                    nextGift[j]++
                } else {
                    val pos = compareGiftIndex(i, j)
                    if (pos != null) nextGift[pos]++
                }
            }
        }

        return nextGift.maxOf { it }
    }

    private fun compareGiftIndex(p1: Int, p2: Int): Int? {
        return when {
            giftIndex[p1][0] - giftIndex[p1][1] > giftIndex[p2][0] - giftIndex[p2][1] -> {
                p1
            }
            giftIndex[p1][0] - giftIndex[p1][1] < giftIndex[p2][0] - giftIndex[p2][1] -> {
                p2
            }
            else -> {
                null
            }
        }
    }
}
