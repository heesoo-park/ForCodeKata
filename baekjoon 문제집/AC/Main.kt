fun main() = with(System.`in`.bufferedReader()) {
    var t = readln().toInt()
    val result = StringBuilder()

    while (t-- > 0) {
        val command = readln()
        var len = readln().toInt()
        val numList = ArrayList<String>()
        var firstIdx = true
        readln().drop(1).dropLast(1).split(",").map { numList.add(it) }

        if (command.count { it == 'D' } > len) {
            result.append("error\n")
            continue
        }

        command.forEach {
            when (it) {
                'R' -> {
                    firstIdx = !firstIdx
                }
                'D' -> {
                    if (firstIdx) {
                        numList.removeAt(0)
                    } else {
                        numList.removeAt(numList.lastIndex)
                    }
                }
            }
        }


        if (firstIdx.not()) {
            numList.reverse()
        }
        result.append("[" + numList.joinToString(",") + "]\n")
    }

    println(result)
}

// 16퍼에서 틀린 코드
fun main() = with(System.`in`.bufferedReader()) {
    var t = readln().toInt()
    val result = StringBuilder()

    while (t-- > 0) {
        val command = readln()
        var len = readln().toInt()
        val numList = ArrayList<String>()
        var firstIdx = true
        readln().drop(1).dropLast(1).split(",").map { numList.add(it) }

        if (command.count { it == 'D' } > len) {
            result.append("error\n")
            continue
        }

        command.forEach {
            when (it) {
                'R' -> {
                    firstIdx = !firstIdx
                }
                'D' -> {
                    if (firstIdx) {
                        numList.removeAt(0)
                    } else {
                        numList.removeAt(numList.lastIndex)
                    }
                }
            }
        }


        result.append("[" + numList.joinToString(",") + "]\n")
    }

    println(result)
}

// 시간초과난 코드
fun main() = with(System.`in`.bufferedReader()) {
    var t = readln().toInt()
    val result = StringBuilder()

    while (t-- > 0) {
        val command = readln()
        val len = readln().toInt()
        val numList = StringBuilder()
        readln().map { if (it != '[' && it != ']' && it != ',') numList.append(it) }

        if (command.count { it == 'D' } > len) {
            result.append("error\n")
            continue
        }

        command.forEach {
            when (it) {
                'R' -> numList.reverse()
                'D' -> numList.deleteCharAt(0)
            }
        }


        result.append("[" + numList.split("").joinToString(",").drop(1).dropLast(1) + "]\n")
    }

    println(result)
}
