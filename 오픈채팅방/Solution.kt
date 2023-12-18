class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        val userData = mutableMapOf<String, String>()
        val messages = mutableListOf<MessageFormat>()
        val splitRecord = record.map { it.split(" ") }

        splitRecord.forEach { it ->
            when (it[0]) {
                "Enter" -> {
                    userData[it[1]] = it[2]
                    messages.add(MessageFormat(it[1], "님이 들어왔습니다."))
                }
                "Leave" -> {
                    messages.add(MessageFormat(it[1], "님이 나갔습니다."))
                }
                "Change" -> {
                    userData[it[1]] = it[2]
                }
            }
        }

        messages.forEach {
            answer += (userData[it.uid] + it.format)
        }
        
        return answer
    }

    data class MessageFormat(var uid: String, var format: String)
}

// 시간초과난 코드(6개)
class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        val uid = mutableListOf<String>()
        val nickname = mutableListOf<String>()
        val messages = mutableListOf<MessageFormat>()
        val splitRecord = record.map { it.split(" ") }

        splitRecord.forEach { it ->
            when (it[0]) {
                "Enter" -> {
                    if (!uid.contains(it[1])) {
                        uid.add(it[1])
                        nickname.add(it[2])
                    } else {
                        nickname[uid.indexOf(it[1])] = it[2]
                    }
                    messages.add(MessageFormat(it[1], "님이 들어왔습니다."))
                }
                "Leave" -> {
                    messages.add(MessageFormat(it[1], "님이 나갔습니다."))
                }
                "Change" -> {
                    nickname[uid.indexOf(it[1])] = it[2]
                }
            }
        }

        messages.forEach {
            answer += (nickname[uid.indexOf(it.uid)] + it.format)
        }
        
        return answer
    }
    
    data class MessageFormat(var uid: String, var format: String)
}

// 원하는 결과가 나오지 않던 코드(다 덮어버림)
class Solution {
    fun solution(record: Array<String>): Array<String> {
        var uid = mutableListOf<String>()
        var nickname = mutableListOf<String>()
        var messages = mutableListOf<StringBuilder>()
        val splitRecord = record.map { it.split(" ") }

        splitRecord.forEach { it ->
            when (it[0]) {
                "Enter" -> {
                    if (!uid.contains(it[1])) {
                        uid += it[1]
                        nickname += it[2]
                        messages += StringBuilder("${it[2]}님이 들어왔습니다.")
                    } else {
                        val prevNickname = nickname[uid.indexOf(it[1])]
                        for (m in messages) {
                            if (m.substring(0, prevNickname.length).equals(prevNickname)) {
                                m.replace(0, prevNickname.length, it[2])
                            }
                        }
                        nickname[uid.indexOf(it[1])] = it[2]
                        messages += StringBuilder("${it[2]}님이 들어왔습니다.")
                    }

                }
                "Leave" -> {
                    messages += StringBuilder("${nickname[uid.indexOf(it[1])]}님이 나갔습니다.")
                }
                "Change" -> {
                    val prevNickname = nickname[uid.indexOf(it[1])]
                    for (m in messages) {
                        if (m.substring(0, prevNickname.length).equals(prevNickname)) {
                            m.replace(0, prevNickname.length, it[2])
                        }
                    }
                    nickname[uid.indexOf(it[1])] = it[2]
                }
            }
        }

        return messages.map { it.toString() }.toTypedArray()
    }
}
