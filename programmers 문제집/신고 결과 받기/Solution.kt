class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer: IntArray = IntArray(id_list.size) {0}
        val checkReport = Array<IntArray>(id_list.size) { IntArray(id_list.size) {0} }
        val ids = mutableMapOf<String, Int>()
        val canStopIds = mutableMapOf<String, Int>()

        for ((index, id) in id_list.withIndex()) {
            ids[id] = index
            canStopIds[id] = 0
        }

        report.forEach {
            val report = it.split(" ")
            val fromIdIndex = ids[report[0]]!!
            val toIdIndex = ids[report[1]]!!

            if (checkReport[fromIdIndex][toIdIndex] < 1) {
                canStopIds[report[1]] = canStopIds[report[1]]!! + 1
                checkReport[fromIdIndex][toIdIndex]++
            }
        }

        for (id in canStopIds) {
            if (id.value >= k) {
                for (item in id_list) {
                    if (checkReport[ids[item]!!][ids[id.key]!!] == 1)  answer[ids[item]!!]++
                }
            }
        }
        
        return answer
    }
}
