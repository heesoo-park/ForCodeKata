class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val check: MutableMap<String, String> = mutableMapOf()
        val calculate: MutableMap<String, Int> = mutableMapOf()

        for (idx in records.indices) {
            val time = records[idx].substring(0..4)
            val carNum = records[idx].substring(6..9)
            val flag = records[idx].substring(11)

            // 입차
            if (flag == "IN" && !check.containsKey(carNum)) {
                check[carNum] = time
                if (!calculate.containsKey(carNum)) calculate[carNum] = 0
            }

            // 출차
            if (flag == "OUT" && check.containsKey(carNum)) {
                val inTime = check[carNum]!!.substring(0..1).toInt() * 60 + check[carNum]!!.substring(3..4).toInt()
                val outTime = time.substring(0..1).toInt() * 60 + time.substring(3..4).toInt()
                val totalTime = outTime - inTime

                calculate[carNum] = calculate[carNum]!!.plus(totalTime)
                check.remove(carNum)
            }
        }
        
        // 출차 안 한 차
        check.forEach {
            val inTime = it.value.substring(0..1).toInt() * 60 + it.value.substring(3..4).toInt()
            val outTime = 1439
            val totalTime = outTime - inTime

            calculate[it.key] = calculate[it.key]!!.plus(totalTime)
        }

        // 주차 계산
        calculate.forEach {
            val totalTime = it.value
            calculate[it.key] = 0

            if (totalTime <= fees[0]) {
                calculate[it.key] = calculate[it.key]!!.plus(fees[1])
            } else {
                val overTime = totalTime - fees[0]
                val overUnitTime = if (overTime % fees[2] != 0) overTime / fees[2] + 1 else overTime / fees[2]

                calculate[it.key] = calculate[it.key]!!.plus(fees[1] + overUnitTime * fees[3])
            }
        }

        val sortedByCarName = calculate.toList().sortedBy { it.first }.toMap()
        for (record in sortedByCarName) {
            answer += record.value
        }

        return answer
    }
}

// 문제를 제대로 안 읽고 입차-출차할 때마다 계산하도록 짠 코드...ㅎㅎ
class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val check: MutableMap<String, String> = mutableMapOf()
        val calculate: MutableMap<String, Int> = mutableMapOf()

        for (idx in records.indices) {
            val time = records[idx].substring(0..4)
            val carNum = records[idx].substring(6..9)
            val flag = records[idx].substring(11)

            // 입차
            if (flag == "IN" && !check.containsKey(carNum)) {
                check[carNum] = time
                if (!calculate.containsKey(carNum)) calculate[carNum] = 0
            }

            // 출차
            if (flag == "OUT" && check.containsKey(carNum)) {
                // 주차 요금 계산
                val inTime = check[carNum]!!.substring(0..1).toInt() * 60 + check[carNum]!!.substring(3..4).toInt()
                val outTime = time.substring(0..1).toInt() * 60 + time.substring(3..4).toInt()
                val totalTime = outTime - inTime

                if (totalTime <= fees[0]) {
                    calculate[carNum] = calculate[carNum]!!.plus(fees[1])
                } else {
                    val overTime = totalTime - fees[0]
                    val overUnitTime = if (overTime % fees[2] != 0) overTime / fees[2] + 1 else overTime / fees[2]
                    calculate[carNum] = calculate[carNum]!!.plus(fees[1] + overUnitTime * fees[3])
                }

                check.remove(carNum)
            }
        }

        // 출차 안 한 차
        check.forEach {
            val inTime = it.value.substring(0..1).toInt() * 60 + it.value.substring(3..4).toInt()
            val outTime = 1439
            val totalTime = outTime - inTime

            if (totalTime <= fees[0]) {
                calculate[it.key] = calculate[it.key]!!.plus(fees[1])
            } else {
                val overTime = totalTime - fees[0]
                val overUnitTime = if (overTime % fees[2] != 0) overTime / fees[2] + 1 else overTime / fees[2]

                calculate[it.key] = calculate[it.key]!!.plus(fees[1] + overUnitTime * fees[3])
            }
        }

        val sortedByCarName = calculate.toList().sortedBy { it.first }.toMap()
        for (record in sortedByCarName) {
            answer += record.value
        }

        return answer
    }
}
