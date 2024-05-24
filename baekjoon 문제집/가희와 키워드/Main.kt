import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    
    val keywords: HashSet<String> = hashSetOf()
    repeat(n) {
        keywords.add(br.readLine())
    }
    
    repeat(m) {
        val usedKeywords = br.readLine().split(',')
        usedKeywords.forEach {
            if (keywords.contains(it)) keywords.remove(it)
        }
        
        bw.write("${keywords.size}\n")
    }
    
    bw.flush()
    bw.close()
}


// 시간초과난 코드3
import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    
    var keywords: HashSet<String> = hashSetOf()
    repeat(n) {
        keywords.add(br.readLine())
    }
    
    repeat(m) {
        val usedKeywords = br.readLine().split(',')
        keywords = keywords.subtract(usedKeywords).toHashSet()
        bw.write("${keywords.size}\n")
    }
    
    bw.flush()
    bw.close()
}


// 시간초과난 코드2
import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    
    val keywords: HashMap<String, Boolean> = hashMapOf()
    repeat(n) {
        keywords[br.readLine()] = false
    }
    
    repeat(m) {
        val usedKeywords = br.readLine().split(',')
        usedKeywords.forEach {
            if (keywords.containsKey(it)) keywords[it] = true
        }
        
        bw.write("${keywords.count { it.value == false }}\n")
    }
    
    bw.flush()
    bw.close()
}


// 시간초과난 코드1
import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    
    var keywords = mutableSetOf<String>()
    repeat(n) {
        keywords.add(br.readLine())
    }
    
    repeat(m) {
        val usedKeywords = br.readLine().split(',').toSet()
        keywords = keywords.subtract(usedKeywords).toMutableSet()
        bw.write("${keywords.size}\n")
    }
    
    bw.flush()
    bw.close()
}
