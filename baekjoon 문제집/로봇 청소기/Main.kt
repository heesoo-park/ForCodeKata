import java.util.StringTokenizer

var count = 0
var n = 0
var m = 0
var r = 0
var c = 0
var d = 0
var room = Array(50) { Array(50) { 0 } }
fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    with(StringTokenizer(readln())) {
        r = nextToken().toInt()
        c = nextToken().toInt()
        d = nextToken().toInt()
    }

    for (i in 0 until n) {
        with(StringTokenizer(readln(), " ")) {
            for (j in 0 until m) {
                room[i][j] = nextToken().toInt()
            }
        }
    }

    solve()
    println(count)
}

fun checkClean(): Boolean {
    return room[r + 1][c] != 0 && room[r][c + 1] != 0 && room[r - 1][c] != 0 && room[r][c - 1] != 0
}

fun solve() {
    if (room[r][c] == 0) {
        room[r][c] = -1
        ++count
    }

    if (checkClean()) {
        when (d) {
            0 -> {
                if (room[r + 1][c] == 1) {
                    return
                } else {
                    r += 1
                }
            }
            1 -> {
                if (room[r][c - 1] == 1) {
                    return
                } else {
                    c -= 1
                }
            }
            2 -> {
                if (room[r - 1][c] == 1) {
                    return
                } else {
                    r -= 1
                }
            }
            3 -> {
                if (room[r][c + 1] == 1) {
                    return
                } else {
                    c += 1
                }
            }
        }
        solve()
    } else {
        d = when (d) {
            0 -> {
                if (room[r][c - 1] == 0) c -= 1
                3
            }
            1 -> {
                if (room[r - 1][c] == 0) r -= 1
                0
            }
            2 -> {
                if (room[r][c + 1] == 0) c += 1
                1
            }
            3 -> {
                if (room[r + 1][c] == 0) r += 1
                2
            }
            else -> -1
        }
        solve()
    }
}
