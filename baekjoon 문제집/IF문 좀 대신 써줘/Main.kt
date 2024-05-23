import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val title = mutableListOf<String>()
    val value = mutableListOf<Int>()
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    
    repeat(n) {
        val (t, v) = br.readLine().split(' ')
        title.add(t)
        value.add(v.toInt())
    }
    
    repeat(m) {
        val power = br.readLine().toInt()
        
        var low = 0
        var high = n - 1
        while (low <= high) {
            val mid = (low + high) / 2
            
            if (power > value[mid]) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        bw.write("${title[low]}\n")
    }
    
    bw.flush()
    bw.close()
}


// 틀린 코드...??
import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val titleMap = mutableMapOf<String, Int>()
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    
    repeat(n) {
        val (t, v) = br.readLine().split(' ')
        titleMap[t] = v.toInt()
    }
    
    repeat(m) {
        val power = br.readLine().toInt()
        
        for ((key, value) in titleMap) {
            if (power <= value) {
                bw.write("$key\n")
                break
            }
        }
    }
    
    bw.flush()
    bw.close()
}
