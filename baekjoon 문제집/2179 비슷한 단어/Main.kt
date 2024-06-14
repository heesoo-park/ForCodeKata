import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    
    val n = br.readLine().toInt()
    val words = mutableListOf<String>()
    
    repeat(n) {
        val word = br.readLine()
        if (!words.contains(word)) words.add(word)
    }
    
    val sortedWords = words.sorted()
    
    var max = 0
    var prefixSet = mutableSetOf<String>()
    for (i in 0 until n - 1) {
        var cnt = 0
        val minLen = minOf(sortedWords[i].length, sortedWords[i + 1].length)
        for (k in 0 until minLen) {
            if (sortedWords[i][k] != sortedWords[i + 1][k]) break
                
            cnt++
        }
            
        if (max == cnt) prefixSet.add(sortedWords[i].substring(0, cnt))
        if (max < cnt) {
            prefixSet = mutableSetOf()
            prefixSet.add(sortedWords[i].substring(0, cnt))
            max = cnt
        }
    }
    
    var prefix = ""
    for (i in words) {
        if (prefix == "") 
        {
            for (j in prefixSet) {
                if (i.length >= j.length && i.substring(0, j.length) == j) {
                    prefix = j
                    sb.append(i + "\n")
                    break
                }
            }
        } else {
            if (i.length >= prefix.length && i.substring(0, prefix.length) == prefix) {
                sb.append(i)
                break
            }
        }
    }
    
    println(sb)
}


// 틀린 코드
import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    
    val n = br.readLine().toInt()
    val words = mutableListOf<String>()
    
    repeat(n) {
        val word = br.readLine()
        if (!words.contains(word)) words.add(word)
    }
    
    val sortedWords = words.sorted()
    
    var max = 0
    var maxPrefix = StringBuilder()
    for (i in 0 until n - 1) {
        var cnt = 0
        val minLen = minOf(sortedWords[i].length, sortedWords[i + 1].length)
        for (k in 0 until minLen) {
            if (sortedWords[i][k] != sortedWords[i + 1][k]) break
                
            cnt++
        }
            
        if (max < cnt) {
            maxPrefix.clear().append(sortedWords[i].substring(0, cnt))
            max = cnt
        }
    }
    
    for (i in words) {
        if (i.length >= maxPrefix.length && i.substring(0, maxPrefix.length) == maxPrefix.toString()) {
            if (sb.isEmpty()) {
                sb.append(i + "\n")                
            } else {
                sb.append(i)
                break
            }
        }
    }
    
    println(sb)
}


// 맞았는데 느린 코드
import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    
    val n = br.readLine().toInt()
    val words = mutableListOf<String>()
    
    repeat(n) {
        val word = br.readLine()
        if (!words.contains(word)) words.add(word)
    }
    
    var max = 0
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            var cnt = 0
            val minLen = minOf(words[i].length, words[j].length)
            for (k in 0 until minLen) {
                if (words[i][k] != words[j][k]) break
                
                cnt++
            }
            
            if (max < cnt) {
                sb.clear().append(words[i] + "\n" + words[j])
                max = cnt
            }
        }
    }
    
    println(sb)
}
