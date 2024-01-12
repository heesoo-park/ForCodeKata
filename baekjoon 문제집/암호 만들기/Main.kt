import java.util.StringTokenizer

var l: Int = 0
var c: Int = 0
lateinit var charArr: CharArray
val result = StringBuilder()

val vowels = listOf('a', 'e', 'i', 'o', 'u')
val consonants = (97..122).map { it.toChar() }.filterNot { vowels.contains(it) }

fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        l = this.nextToken().toInt()
        c = this.nextToken().toInt()
    }

    charArr = readln().filter { it != ' ' }.toCharArray().sortedArray()

    findCode(0, 0, StringBuilder())
    println(result)
}

fun findCode(len: Int, start: Int, code: StringBuilder) {
    if (len == l) {
        if (code.count { it in vowels } > 0 
            && code.count { it in consonants} > 1) result.append(code).append("\n")
        return
    }

    for (i in start until charArr.size) {
        code.append(charArr[i])
        findCode(len + 1, i + 1, code)
        code.deleteCharAt(code.lastIndex)
    }
}

// 반복문으로 통과한 코드
import java.util.StringTokenizer

var l: Int = 0
var c: Int = 0
lateinit var charArr: CharArray
val result = StringBuilder()

val vowels = listOf('a', 'e', 'i', 'o', 'u')
val consonants = (97..122).map { it.toChar() }.filterNot { vowels.contains(it) }

fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        l = this.nextToken().toInt()
        c = this.nextToken().toInt()
    }

    charArr = readln().filter { it != ' ' }.toCharArray().sortedArray()

    findCode(0, 0, StringBuilder())
    println(result)
}

fun findCode(len: Int, start: Int, code: StringBuilder) {
    if (len == l) {
        var v = 0
        var c = 0
        code.forEach {
            if (vowels.contains(it)) {
                v++
            } else {
                c++
            }
        }
        if (v > 0 && c > 1) result.append(code).append("\n")
        
        return
    }

    for (i in start until charArr.size) {
        code.append(charArr[i])
        findCode(len + 1, i + 1, code)
        code.deleteCharAt(code.lastIndex)
    }
}

// 3퍼에서 틀린 코드 3
import java.util.StringTokenizer

var l: Int = 0
var c: Int = 0
lateinit var charArr: CharArray
val result = StringBuilder()

val vowels = listOf('a', 'e', 'i', 'o', 'u')
val consonants = (97..122).map { it.toChar() }.filterNot { vowels.contains(it) }

fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        l = this.nextToken().toInt()
        c = this.nextToken().toInt()
    }

    charArr = readln().filter { it != ' ' }.toCharArray().sortedArray()

    findCode(0, 0, StringBuilder())
    println(result)
}

fun findCode(len: Int, start: Int, code: StringBuilder) {
    if (len == l) {
        if (code.filterNot { vowels.contains(it) }.isNotEmpty() && code.filterNot { consonants.contains(it) }.length > 1) result.append(code).append("\n")
        return
    }

    for (i in start until charArr.size) {
        code.append(charArr[i])
        findCode(len + 1, i + 1, code)
        code.deleteCharAt(code.lastIndex)
    }
}

// 3퍼에서 틀린 코드 2
import java.util.StringTokenizer

var l: Int = 0
var c: Int = 0
lateinit var charArr: CharArray
val result = StringBuilder()

val vowels = listOf('a', 'e', 'i', 'o', 'u')
val consonants = (97..122).map { it.toChar() }.filterNot { vowels.contains(it) }

fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        l = this.nextToken().toInt()
        c = this.nextToken().toInt()
    }

    charArr = readln().filter { it != ' ' }.toCharArray().sortedArray()

    findCode(0, 0, StringBuilder())
    println(result)
}

fun findCode(len: Int, start: Int, code: StringBuilder) {
    if (len == l) {
        if (code.contains(Regex(vowels.joinToString("")))
            && code.contains(Regex("${consonants.joinToString("")} {2,}"))) result.append(code).append("\n")
        return
    }

    for (i in start until charArr.size) {
        code.append(charArr[i])
        findCode(len + 1, i + 1, code)
        code.deleteCharAt(code.lastIndex)
    }
}


// 3퍼에서 틀린 코드 1
import java.util.StringTokenizer

var l: Int = 0
var c: Int = 0
lateinit var charArr: CharArray
val result = StringBuilder()

val vowels = listOf('a', 'e', 'i', 'o', 'u')
val consonants = (97..122).map { it.toChar() }.filterNot { vowels.contains(it) }

fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        l = this.nextToken().toInt()
        c = this.nextToken().toInt()
    }

    charArr = readln().filter { it != ' ' }.toCharArray().sortedArray()

    findCode(0, 0, StringBuilder())
    println(result)
}

fun findCode(len: Int, start: Int, code: StringBuilder) {
    if (len == l) {
        if (code.contains(Regex(vowels.joinToString("")))
            && code.contains(Regex(consonants.joinToString("")))) result.append(code).append("\n")
        return
    }

    for (i in start until charArr.size) {
        code.append(charArr[i])
        findCode(len + 1, i + 1, code)
        code.deleteCharAt(code.lastIndex)
    }
}

// 24퍼?에서 틀린 코드
import java.util.StringTokenizer

var l: Int = 0
var c: Int = 0
lateinit var charArr: CharArray
val result = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readln())) {
        l = this.nextToken().toInt()
        c = this.nextToken().toInt()
    }

    charArr = readln().filter { it != ' ' }.toCharArray().sortedArray()

    findCode(0, 0, StringBuilder())
    println(result)
}

fun findCode(len: Int, start: Int, code: StringBuilder) {
    if (len == l) {
        if (code.contains(Regex("[aeiou]"))) result.append(code).append("\n")
        return
    }

    for (i in start until charArr.size) {
        code.append(charArr[i])
        findCode(len + 1, i + 1, code)
        code.deleteCharAt(code.lastIndex)
    }
}
