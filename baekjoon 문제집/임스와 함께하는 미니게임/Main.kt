import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, c) = readln().split(' ')
    val requestList = mutableListOf<String>()

    repeat(n.toInt()) {
        requestList.add(readln())
    }

    val people = requestList.groupingBy { it }.eachCount().keys

    when (c) {
        "Y" -> bw.write("${people.size}")
        "F" -> bw.write("${people.size / 2}")
        "O" -> bw.write("${people.size / 3}")
    }

    bw.flush()
    bw.close()
}
