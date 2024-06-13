import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stack = Stack<Char>()
    
    val str = br.readLine()
    val target = br.readLine()
    
    var idx = 0
    while (true) {
        if (idx >= str.length) break
        
        stack.push(str[idx])
        if (target.last() == str[idx]) {
            var temp = StringBuilder()
            for (i in 0 until target.length) {
                if (stack.isNotEmpty()) temp.append(stack.pop())
            }
            
            val check = temp.reverse().toString()
            if (check != target) {
                for (i in 0 until check.length) {
                    stack.push(check[i])
                }
            }
        }
        
        idx++
    }
    
    if (stack.isNotEmpty()) {
        val sb = StringBuilder()
        for (i in 0 until stack.size) {
            sb.append(stack.pop())
        }
        println(sb.reverse().toString())
    } else {
        println("FRULA")
    }
}
