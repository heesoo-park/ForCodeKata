import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var rooms: Array<Array<LocalTime>> = arrayOf()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val sortBookTime = book_time.sortedBy { it.first() }

        rooms += sortBookTime[0].map { LocalTime.parse(it, formatter) }.toTypedArray()
        for (i in 1 until sortBookTime.size) {
            val cur = sortBookTime[i].map { LocalTime.parse(it, formatter) }.toTypedArray()
            var pass = false
            for (j in rooms.indices) {
                if (rooms[j][1].isAfter(LocalTime.parse("23:49", formatter))) {
                    continue
                }

                if (rooms[j][1].plusMinutes(10) <= cur[0] && !pass) {
                    rooms[j][1] = cur[1]
                    pass = true
                }
            }
            if (!pass) rooms += cur
        }

        return rooms.size
    }
}

// 시간을 분으로 바꿔서 진행한 코드
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var rooms: Array<Array<Int>> = arrayOf()
        var sortBookTime = book_time.sortedBy { it.first() }.map { it.map { time -> time.slice(0..1).toInt() * 60 + time.slice(3..4).toInt() } }

        rooms += sortBookTime[0].toTypedArray()
        for (i in 1 until sortBookTime.size) {
            val cur = sortBookTime[i]
            var pass = false
            for (j in rooms.indices) {
                if (rooms[j][1] + 10 <= cur[0] && !pass) {
                    rooms[j][1] = cur[1]
                    pass = true
                    break
                }
            }
            if (!pass) rooms += cur.toTypedArray()
        }

        return rooms.size
    }
}

// 입력 배열을 정렬했던 절반 맞은 코드
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var rooms:Array<Array<LocalTime>> = arrayOf()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val sortBookTime = book_time.sortedBy { it.first() }

        rooms += sortBookTime[0].map { LocalTime.parse(it, formatter) }.toTypedArray()
        for (i in 1 until book_time.size) {
            val cur = sortBookTime[i].map { LocalTime.parse(it, formatter) }.toTypedArray()
            var pass = false
            rooms.forEach {
                if (it[0] >= cur[1].plusMinutes(10) && !pass) {
                    it[0] = cur[0]
                    pass = true
                } else if (it[1].plusMinutes(10) <= cur[0] && !pass) {
                    it[1] = cur[1]
                    pass = true
                }
            }
            if (!pass) rooms += cur
        }

        return rooms.size
    }
}

// 아래보다 1개 더 맞은 코드
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var rooms:Array<Array<LocalTime>> = arrayOf()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")

        rooms += book_time[0].map { LocalTime.parse(it, formatter) }.toTypedArray()
        for (i in 1 until book_time.size) {
            val cur = book_time[i].map { LocalTime.parse(it, formatter) }.toTypedArray()
            var pass = false
            rooms.forEach {
                if (it[0] >= cur[1].plusMinutes(10) && !pass) {
                    it[0] = cur[0]
                    pass = true
                } else if (it[1].plusMinutes(10) <= cur[0] && !pass) {
                    it[1] = cur[1]
                    pass = true
                }
            }
            if (!pass) rooms += cur
        }

        return rooms.size
    }
}

// 대부분 틀린 코드
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var rooms:Array<Array<LocalTime>> = arrayOf()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")

        rooms += book_time[0].map { LocalTime.parse(it, formatter) }.toTypedArray()
        for (i in 1 until book_time.size) {
            val cur = book_time[i].map { LocalTime.parse(it, formatter) }.toTypedArray()
            var pass = 0
            rooms.forEach {
                if (it[0] >= cur[1].plusMinutes(10)) {
                    it[0] = cur[0]
                } else if (it[1].plusMinutes(10) <= cur[0]) {
                    it[1] = cur[1]
                } else {
                    pass++
                }
            }
            if (pass == rooms.size) rooms += cur
        }

        return rooms.size
    }
}
