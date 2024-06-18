import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val buildings = IntArray(n + 1)
    val proximate = IntArray(n + 1) { -100000 }
    val count = IntArray(n + 1)

    val st = StringTokenizer(br.readLine())
    for (i in 1..n) {
        buildings[i] = st.nextToken().toInt()
    }

    var stack = Stack<Int>()
    for (cur in 1..n) {
        while (stack.isNotEmpty() && buildings[stack.peek()] <= buildings[cur]) stack.pop()

        count[cur] = stack.size
        if (count[cur] > 0) proximate[cur] = stack.peek()
        stack.push(cur)
    }

    stack = Stack<Int>()
    for (cur in n downTo 1) {
        while (stack.isNotEmpty() && buildings[stack.peek()] <= buildings[cur]) stack.pop()

        count[cur] += stack.size
        if (stack.isNotEmpty() && stack.peek() - cur < cur - proximate[cur]) proximate[cur] = stack.peek()
        stack.push(cur)
    }

    for (i in 1..n) {
        if (count[i] != 0) sb.append("${count[i]} ${proximate[i]}\n") else sb.append("0\n")
    }
    print(sb)
}

// O(N^2)으로 짜 시간초과난 코드
import java.io.*
import java.util.*
import kotlin.math.*

data class Info(
    val num: Int,
    val height: Int
)

var n = -1
private lateinit var buildings: List<Info>

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    
    var cnt = 1
    n = br.readLine().toInt()
    buildings = br.readLine().split(' ').map { Info(cnt++, it.toInt()) }
    
    for (cur in 0 until n) {
        val result = countCanSeeBuildings(cur)
   
        if (result.first == 0) sb.append("0\n") else sb.append("${result.first} ${result.second}\n")
    }
    
    print(sb)
}

fun countCanSeeBuildings(cur: Int): Pair<Int, Int> {
        val stack = Stack<Info>()
        var proximate = -1
        
        val stack2 = Stack<Info>()
        var proximate2 = -1
        
        var cnt = 0
        
        when (cur) {
            0 -> {
                for (idx in 1 until n) {
                    if (stack.isEmpty()) {
                        if (buildings[cur].height < buildings[idx].height) stack.push(buildings[idx])
                    } else {
                        if (stack.peek().height < buildings[idx].height) stack.push(buildings[idx])
                    }
                }
            }
            
            n - 1 -> {
                for (idx in n - 2 downTo 0) {
                    if (stack.isEmpty()) {
                        if (buildings[cur].height < buildings[idx].height) stack.push(buildings[idx])
                    } else {
                        if (stack.peek().height < buildings[idx].height) stack.push(buildings[idx])
                    }
                }
            }
            
            else -> {    
                for (idx in cur - 1 downTo 0) {
                    if (stack.isEmpty()) {
                        if (buildings[cur].height < buildings[idx].height) stack.push(buildings[idx])
                    } else {
                        if (stack.peek().height < buildings[idx].height) stack.push(buildings[idx])
                    }
                }
            
                for (idx in cur + 1 until n) {
                    if (stack2.isEmpty()) {
                        if (buildings[cur].height < buildings[idx].height) stack2.push(buildings[idx])
                    } else {
                        if (stack2.peek().height < buildings[idx].height) stack2.push(buildings[idx])
                    }
                }
            }
        }
        
        when (cur) {
            0, n - 1 -> {
                while (stack.isNotEmpty()) {
                    cnt++
                    val temp = stack.pop()
                    if (stack.isEmpty()) proximate = temp.num
                }
            }
            
            else -> {
                while (stack.isNotEmpty()) {
                    cnt++
                    val temp = stack.pop()
                    if (stack.isEmpty()) proximate = temp.num
                }
                
                while (stack2.isNotEmpty()) {
                    cnt++
                    val temp = stack2.pop()
                    if (stack2.isEmpty()) {
                        proximate = checkAbs(cur, proximate, temp.num)
                    }
                }
            }
        }
        
        return Pair(cnt, proximate)
    }

fun checkAbs(target: Int, num1: Int, num2: Int): Int {
    return if (abs(target - num1) > abs(target - num2)) {
        num2
    } else if (abs(target - num1) < abs(target - num2)) {
        num1
    } else {
        minOf(num1, num2)
    }
}
