var answer = listOf<String>()
fun main() = with(System.`in`.bufferedReader()) {
    val k = readln().toInt()
    val inequalitySign = readln().filter { it != ' ' }
    val visited = BooleanArray(10) {false}

    solve(inequalitySign, visited, "", 0)

    println(answer.sorted()[answer.size - 1])
    println(answer.sorted()[0])
}

fun solve(sign: String, visited: BooleanArray, num: String, cnt: Int) {
    if (num.length == sign.length + 1) {
        answer += num
        return
    }

    for (i in 0..9) {
        if (!visited[i]) {
            if (num.isEmpty()) {
                visited[i] = true
                solve(sign, visited, num + i.toString(), cnt)
                visited[i] = false
            } else {
                when (sign[cnt]) {
                    '<' -> {
                        if (num[num.length - 1] - '0' < i) {
                            visited[i] = true
                            solve(sign, visited, num + i.toString(), cnt + 1)
                            visited[i] = false
                        }
                    }
                    '>' -> {
                        if (num[num.length - 1] - '0' > i) {
                            visited[i] = true
                            solve(sign, visited, num + i.toString(), cnt + 1)
                            visited[i] = false
                        }
                    }
                }
            }
        }
    }
}
