class Solution {
    private val table = arrayOf(arrayOf(1, 1, 1), arrayOf(5, 1, 1), arrayOf(25, 5, 1))
    private val tier = hashMapOf("diamond" to 1, "iron" to 2, "stone" to 3)
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer = 0
        val blockList = minerals.map { tier[it] }.chunked(5).let { list ->
            list.subList(0, if (list.size > picks.sumOf { it }) picks.sumOf { it } else list.size).sortedWith(
                compareBy({ dia -> -dia.count { it == 1 } }, { iron -> -iron.count { it == 2 } }, { stone -> -stone.count { it == 3 } })
            )
        }

        blockList.forEach { block ->
            if (picks[0] != 0) {
                answer += calTiredness(block, 0)
                picks[0]--
            } else if (picks[1] != 0) {
                answer += calTiredness(block, 1)
                picks[1]--
            } else {
                answer += calTiredness(block, 2)
                picks[2]--
            }
        }

        return answer
    }

    private fun calTiredness(block: List<Int?>, num: Int): Int {
        return block.sumOf { table[num][it?.minus(1)!!] }
    }
}

// 60점짜리 코드
class Solution {
    val table = arrayOf(arrayOf(1, 1, 1), arrayOf(5, 1, 1), arrayOf(25, 5, 1))
    val tier = hashMapOf("diamond" to 1, "iron" to 2, "stone" to 3)
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0
        val blockList = minerals.map { tier[it] }.chunked(5)
        blockList.forEach { block ->
            when (block.minOf { it ?: 0 }) {
                1 -> {
                    if (picks[0] != 0) {
                        answer += calTiredness(block, 0)
                        picks[0]--
                    } else if (picks[1] != 0) {
                        answer += calTiredness(block, 1)
                        picks[1]--
                    } else if (picks[2] != 0) {
                        answer += calTiredness(block, 2)
                        picks[2]--
                    }
                }
                2 -> {
                    if (picks[1] != 0) {
                        answer += calTiredness(block, 1)
                        picks[1]--
                    } else if (picks[0] != 0) {
                        answer += calTiredness(block, 0)
                        picks[0]--
                    } else if (picks[2] != 0) {
                        answer += calTiredness(block, 2)
                        picks[2]--
                    }
                }
                3 -> {
                    if (picks[2] != 0) {
                        answer += calTiredness(block, 2)
                        picks[2]--
                    } else if (picks[1] != 0) {
                        answer += calTiredness(block, 1)
                        picks[1]--
                    } else if (picks[0] != 0)  {
                        answer += calTiredness(block, 0)
                        picks[0]--
                    }
                }
            }
        }

        return answer
    }

    private fun calTiredness(block: List<Int?>, num: Int): Int {
        return block.sumOf { table[num][it?.minus(1)!!] }
    }
}
