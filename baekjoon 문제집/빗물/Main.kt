// 맞은 코드
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var answer = 0
    var st = StringTokenizer(readln())
    val h = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val blocks = arrayListOf<Int>()

    st = StringTokenizer(readln(), " ")
    repeat(w) {
        blocks.add(st.nextToken().toInt())
    }

    for (i in 1 until blocks.lastIndex) {
        val min = minOf(blocks.slice(0 until i).maxOf { it }, blocks.slice(i + 1..blocks.lastIndex).maxOf { it })

        if (min > blocks[i]) answer += (min - blocks[i])
    }

    println(answer)
}

// 틀린 코드
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var answer = 0
    var st = StringTokenizer(readln())
    val h = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val blocks = arrayListOf<Int>()

    st = StringTokenizer(readln(), " ")
    repeat(w) {
        blocks.add(st.nextToken().toInt())
    }

    var start = 0
    for (i in 1 until blocks.size) {
        if (blocks[start] <= blocks[i]) {
            val min = minOf(blocks[start], blocks[i])
            for (j in start + 1 until i) {
                answer += (min - blocks[j])
            }
            start = i
        }
    }

    start = blocks.lastIndex
    for (i in blocks.lastIndex - 1 downTo  0) {
        if (blocks[start] <= blocks[i]) {
            val min = minOf(blocks[start], blocks[i])
            for (j in start - 1 downTo i + 1) {
                answer += (min - blocks[j])
            }
            start = i
        }
    }

    println(answer)
}
