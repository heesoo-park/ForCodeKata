// 맞은 코드
import java.util.StringTokenizer

val gears: Array<StringBuilder> = Array(4) { StringBuilder() }
fun main() = with(System.`in`.bufferedReader()) {
    var answer = 0

    (0..3).forEach {
        gears[it].append(readln())
    }

    var k = readln().toInt()
    while (k-- > 0) {
        val st = StringTokenizer(readln())
        val num = st.nextToken().toInt()
        val dir = st.nextToken().toInt()

        when (num - 1) {
            0 -> checkOne(dir)
            1 -> checkTwo(dir)
            2 -> checkThree(dir)
            3 -> checkFour(dir)
        }
    }

    if (gears[0][0] - '0' == 1) answer += 1
    if (gears[1][0] - '0' == 1) answer += 2
    if (gears[2][0] - '0' == 1) answer += 4
    if (gears[3][0] - '0' == 1) answer += 8

    println(answer)
}

fun checkOne(dir: Int) {
    rotateGear(0, dir)

    if (gears[0][2 + dir] != gears[1][6]) {
        rotateGear(1, dir * -1)
    } else {
        return
    }

    if (gears[1][2 + dir * -1] != gears[2][6]) {
        rotateGear(2, dir)
    } else {
        return
    }

    if (gears[2][2 + dir] != gears[3][6]) {
        rotateGear(3, dir * -1)
    } else {
        return
    }
}

fun checkTwo(dir: Int) {
    rotateGear(1, dir)

    if (gears[1][6 + dir] != gears[0][2]) {
        rotateGear(0, dir * -1)
    }

    if (gears[1][2 + dir] != gears[2][6]) {
        rotateGear(2, dir * -1)
    } else {
        return
    }

    if (gears[2][2 + dir * -1] != gears[3][6]) {
        rotateGear(3, dir)
    } else {
        return
    }
}

fun checkThree(dir: Int) {
    rotateGear(2, dir)

    if (gears[2][2 + dir] != gears[3][6]) {
        rotateGear(3, dir * -1)
    }

    if (gears[2][6 + dir] != gears[1][2]) {
        rotateGear(1, dir * -1)
    } else {
        return
    }

    if (gears[1][6 + dir * -1] != gears[0][2]) {
        rotateGear(0, dir)
    } else {
        return
    }
}

fun checkFour(dir: Int) {
    rotateGear(3, dir)

    if (gears[3][6 + dir] != gears[2][2]) {
        rotateGear(2, dir * -1)
    } else {
        return
    }

    if (gears[2][6 + dir * -1] != gears[1][2]) {
        rotateGear(1, dir)
    } else {
        return
    }

    if (gears[1][6 + dir] != gears[0][2]) {
        rotateGear(0, dir * -1)
    } else {
        return
    }
}

fun rotateGear(idx: Int, dir: Int) {
    when (dir) {
        1 -> {
            gears[idx].insert(0, gears[idx][gears[idx].lastIndex])
            gears[idx].deleteCharAt(gears[idx].lastIndex)
        }
        -1 -> {
            gears[idx].append(gears[idx][0])
            gears[idx].deleteCharAt(0)
        }
    }
}

// 틀린 코드
import java.util.StringTokenizer

val gears: Array<StringBuilder> = Array(4) { StringBuilder() }
fun main() = with(System.`in`.bufferedReader()) {
    var answer = 0

    (0..3).forEach {
        gears[it].append(readln())
    }

    var k = readln().toInt()
    while (k-- > 0) {
        val st = StringTokenizer(readln())
        val num = st.nextToken().toInt()
        val dir = st.nextToken().toInt()

        when (num - 1) {
            0 -> checkOne(dir)
            1 -> checkTwo(dir)
            2 -> checkThree(dir)
            3 -> checkFour(dir)
        }
    }

    if (gears[0][0] - '0' == 1) answer += 1
    if (gears[1][0] - '0' == 1) answer += 2
    if (gears[2][0] - '0' == 1) answer += 4
    if (gears[3][0] - '0' == 1) answer += 8

    println(answer)
}

fun checkOne(dir: Int) {
    rotateGear(0, dir)

    if (gears[0][2 + dir] != gears[1][6]) {
        rotateGear(1, dir * -1)
    } else {
        return
    }

    if (gears[1][2 + dir * -1] != gears[2][6]) {
        rotateGear(2, dir)
    } else {
        return
    }

    if (gears[2][2 + dir] != gears[3][6]) {
        rotateGear(3, dir * -1)
    } else {
        return
    }
}

fun checkTwo(dir: Int) {
    rotateGear(1, dir)

    if (gears[1][6 + dir] != gears[0][2]) {
        rotateGear(0, dir * -1)
    }

    if (gears[1][2 + dir] != gears[2][6]) {
        rotateGear(2, dir * -1)
    } else {
        return
    }

    if (gears[2][2 + dir * -1] != gears[3][6]) {
        rotateGear(3, dir)
    } else {
        return
    }
}

fun checkThree(dir: Int) {
    rotateGear(2, dir)

    if (gears[2][2 + dir] != gears[3][6]) {
        rotateGear(3, dir * -1)
    }

    if (gears[2][6 + dir] != gears[1][2]) {
        rotateGear(1, dir * -1)
    } else {
        return
    }

    if (gears[1][6 + dir * -1] != gears[0][2]) {
        rotateGear(0, dir)
    } else {
        return
    }
}

fun checkFour(dir: Int) {
    rotateGear(3, dir)

    if (gears[3][6 + dir] != gears[2][2]) {
        rotateGear(2, dir * -1)
    } else {
        return
    }

    if (gears[2][6 + dir * -1] != gears[1][2]) {
        rotateGear(1, dir)
    } else {
        return
    }

    if (gears[1][6 + dir] != gears[0][2]) {
        rotateGear(2, dir * -1)
    } else {
        return
    }
}

fun rotateGear(idx: Int, dir: Int) {
    when (dir) {
        1 -> {
            gears[idx].insert(0, gears[idx][gears[idx].lastIndex])
            gears[idx].deleteCharAt(gears[idx].lastIndex)
        }
        -1 -> {
            gears[idx].append(gears[idx][0])
            gears[idx].deleteCharAt(0)
        }
    }
}

// 틀린 코드
import java.util.StringTokenizer

val gears: Array<StringBuilder> = Array(4) { StringBuilder() }
fun main() = with(System.`in`.bufferedReader()) {
    var answer = 0

    (0..3).forEach {
        gears[it].append(readln())
    }

    var k = readln().toInt()
    while (k-- > 0) {
        val st = StringTokenizer(readln())
        val num = st.nextToken().toInt()
        val dir = st.nextToken().toInt()

        when (num - 1) {
            0 -> checkOne(dir)
            1 -> checkTwo(dir)
            2 -> checkThree(dir)
            3 -> checkFour(dir)
        }
    }

    if (gears[0][0] - '0' == 1) answer += 1
    if (gears[1][0] - '0' == 1) answer += 2
    if (gears[2][0] - '0' == 1) answer += 4
    if (gears[3][0] - '0' == 1) answer += 8

    println(answer)
}

fun checkOne(dir: Int) {
    when (dir) {
        1 -> {
            gears[0].insert(0, gears[0][gears[0].lastIndex])
            gears[0].deleteCharAt(gears[0].lastIndex)
        }
        -1 -> {
            gears[0].append(gears[0][0])
            gears[0].deleteCharAt(0)
        }
    }


    if (gears[0][2 + dir] != gears[1][6]) {
        when (dir * -1) {
            1 -> {
                gears[1].insert(0, gears[1][gears[1].lastIndex])
                gears[1].deleteCharAt(gears[1].lastIndex)
            }
            -1 -> {
                gears[1].append(gears[1][0])
                gears[1].deleteCharAt(0)
            }
        }
    } else {
        return
    }

    if (gears[1][2 + dir * -1] != gears[2][6]) {
        when (dir) {
            1 -> {
                gears[2].insert(0, gears[2][gears[2].lastIndex])
                gears[2].deleteCharAt(gears[2].lastIndex)
            }
            -1 -> {
                gears[2].append(gears[2][0])
                gears[2].deleteCharAt(0)
            }
        }
    } else {
        return
    }

    if (gears[2][2 + dir] != gears[3][6]) {
        when (dir * -1) {
            1 -> {
                gears[3].insert(0, gears[3][gears[3].lastIndex])
                gears[3].deleteCharAt(gears[3].lastIndex)
            }
            -1 -> {
                gears[3].append(gears[3][0])
                gears[3].deleteCharAt(0)
            }
        }
    } else {
        return
    }
}

fun checkTwo(dir: Int) {
    when (dir) {
        1 -> {
            gears[1].insert(0, gears[1][gears[1].lastIndex])
            gears[1].deleteCharAt(gears[1].lastIndex)
        }
        -1 -> {
            gears[1].append(gears[1][0])
            gears[1].deleteCharAt(0)
        }
    }

    if (gears[1][6 + dir] != gears[0][2]) {
        when (dir * -1) {
            1 -> {
                gears[0].insert(0, gears[0][gears[0].lastIndex])
                gears[0].deleteCharAt(gears[0].lastIndex)
            }
            -1 -> {
                gears[0].append(gears[0][0])
                gears[0].deleteCharAt(0)
            }
        }
    }

    if (gears[1][2 + dir] != gears[2][6]) {
        when (dir * 1) {
            1 -> {
                gears[2].insert(0, gears[2][gears[2].lastIndex])
                gears[2].deleteCharAt(gears[2].lastIndex)
            }
            -1 -> {
                gears[2].append(gears[2][0])
                gears[2].deleteCharAt(0)
            }
        }
    } else {
        return
    }

    if (gears[2][2 + dir] != gears[3][6]) {
        when (dir * -1) {
            1 -> {
                gears[3].insert(0, gears[3][gears[3].lastIndex])
                gears[3].deleteCharAt(gears[3].lastIndex)
            }
            -1 -> {
                gears[3].append(gears[3][0])
                gears[3].deleteCharAt(0)
            }
        }
    } else {
        return
    }
}

fun checkThree(dir: Int) {
    when (dir) {
        1 -> {
            gears[2].insert(0, gears[2][gears[2].lastIndex])
            gears[2].deleteCharAt(gears[2].lastIndex)
        }
        -1 -> {
            gears[2].append(gears[2][0])
            gears[2].deleteCharAt(0)
        }
    }

    if (gears[2][2 + dir] != gears[3][6]) {
        when (dir * -1) {
            1 -> {
                gears[3].insert(0, gears[3][gears[3].lastIndex])
                gears[3].deleteCharAt(gears[3].lastIndex)
            }
            -1 -> {
                gears[3].append(gears[3][0])
                gears[3].deleteCharAt(0)
            }
        }
    }

    if (gears[2][6 + dir] != gears[1][2]) {
        when (dir * 1) {
            1 -> {
                gears[1].insert(0, gears[1][gears[1].lastIndex])
                gears[1].deleteCharAt(gears[1].lastIndex)
            }
            -1 -> {
                gears[1].append(gears[1][0])
                gears[1].deleteCharAt(0)
            }
        }
    } else {
        return
    }

    if (gears[1][6 + dir] != gears[0][2]) {
        when (dir * -1) {
            1 -> {
                gears[0].insert(0, gears[0][gears[0].lastIndex])
                gears[0].deleteCharAt(gears[0].lastIndex)
            }
            -1 -> {
                gears[0].append(gears[0][0])
                gears[0].deleteCharAt(0)
            }
        }
    } else {
        return
    }
}

fun checkFour(dir: Int) {
    when (dir) {
        1 -> {
            gears[3].insert(0, gears[3][gears[3].lastIndex])
            gears[3].deleteCharAt(gears[3].lastIndex)
        }
        -1 -> {
            gears[3].append(gears[3][0])
            gears[3].deleteCharAt(0)
        }
    }

    if (gears[3][6 + dir] != gears[2][2]) {
        when (dir * -1) {
            1 -> {
                gears[2].insert(0, gears[2][gears[2].lastIndex])
                gears[2].deleteCharAt(gears[2].lastIndex)
            }
            -1 -> {
                gears[2].append(gears[2][0])
                gears[2].deleteCharAt(0)
            }
        }
    } else {
        return
    }

    if (gears[2][6 + dir * -1] != gears[1][2]) {
        when (dir) {
            1 -> {
                gears[1].insert(0, gears[1][gears[1].lastIndex])
                gears[1].deleteCharAt(gears[1].lastIndex)
            }
            -1 -> {
                gears[1].append(gears[1][0])
                gears[1].deleteCharAt(0)
            }
        }
    } else {
        return
    }

    if (gears[1][6 + dir] != gears[0][2]) {
        when (dir * -1) {
            1 -> {
                gears[0].insert(0, gears[0][gears[0].lastIndex])
                gears[0].deleteCharAt(gears[0].lastIndex)
            }
            -1 -> {
                gears[0].append(gears[0][0])
                gears[0].deleteCharAt(0)
            }
        }
    } else {
        return
    }
}
