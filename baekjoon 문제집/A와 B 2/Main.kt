// 결과값 저장 변수
var result = 0

fun main() = with(System.`in`.bufferedReader()) {
    val s = readln()
    val t = readln()

    solve(s, t)
    println(result)
}

fun solve(target: String, current: String) {
    // 길이가 같고
    if (current.length == target.length) {
        // 같은 문자열일 때
        if (current == target) {
            result = 1
        }

        return
    }

    // 첫 문자가 B인 경우
    if (current[0] == 'B') {
        val temp = current.substring(1).reversed()
        solve(target, temp)
    }

    // 마지막 문자가 A인 경우
    if (current.last() == 'A') {
        val temp = current.substring(0, current.length - 1)
        solve(target, temp)
    }
}

// 시간초과난 코드
var result = 0

fun main() = with(System.`in`.bufferedReader()) {
    val s = readln()
    val t = readln()
    
    solve(StringBuilder(s), t)
    println(result)
}

fun solve(current: StringBuilder, target: String) {
    if (current.length == target.length) {
        if (current.toString() == target) {
            result = 1
        }
        return
    }

    if (result != 1) {
        solve(current.append('A'), target)
        current.deleteCharAt(current.lastIndex)

        solve(current.append('B').reverse(), target)
        current.reverse().deleteCharAt(current.lastIndex)
    }
}
