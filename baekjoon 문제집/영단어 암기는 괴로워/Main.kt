import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val wordList = mutableMapOf<String, Int>()

    for (i in 0 until n) {
        val word = br.readLine()
        if (word.length >= m) {
            if (wordList.containsKey(word)) wordList[word] = wordList[word]!! + 1
            else wordList[word] = 1
        }
    }

    val result = wordList.entries.sortedWith(compareBy<Map.Entry<String, Int>?> { it?.value?.times(-1) }.thenBy { it?.key?.length?.times(-1) }.thenBy { it?.key })

    result.forEach {
        bw.write("${it.key}\n")
    }

    bw.flush()
    bw.close()
}


// 시간초과난 코드
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val wordList = mutableListOf<String>()

    for (i in 0 until n) {
        val word = br.readLine()
        if (word.length >= m) wordList.add(word)
    }

    val wordHashMap = wordList.groupingBy { it }.eachCount()
    val wordLinkedList = LinkedList(wordHashMap.entries)
    wordLinkedList.sortWith(compareBy<Map.Entry<String, Int>?> { it?.value?.times(-1) }.thenBy { it?.key?.length?.times(-1) }.thenBy { it?.key })

    wordLinkedList.forEach {
        bw.write("${it.key}\n")
    }

    bw.flush()
    bw.close()
}
