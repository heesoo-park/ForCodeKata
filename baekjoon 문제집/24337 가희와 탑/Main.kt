import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    
    val (n, a, b) = br.readLine().split(' ').map { it.toInt() }
    val buildings = mutableListOf<Int>()
    
    if (a + b > n + 1) {
        print(-1)
        return
    }
    
    for (i in 1 until a) {
        buildings.add(i)
    }
    
    buildings.add(maxOf(a, b))
    
    for (i in b - 1 downTo 1) {
        buildings.add(i)
    }
    
    while (buildings.size < n) {
        if (a == 1) buildings.add(1, 1) else buildings.add(0, 1)
    }
    
    for (building in buildings) {
        sb.append("$building ")
    }
    print(sb)
}

// 내가 생각하기에 순차적인 코드
import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    
    val (n, a, b) = br.readLine().split(' ').map { it.toInt() }
    val buildings = mutableListOf<Int>()
    
    for (i in 1 until a) {
        buildings.add(i)
    }
    
    buildings.add(maxOf(a, b))
    
    for (i in b - 1 downTo 1) {
        buildings.add(i)
    }
    
    if (buildings.size > n) {
        print(-1)
        return
    }
    
    while (buildings.size < n) {
        if (a == 1) buildings.add(1, 1) else buildings.add(0, 1)
    }
    
    for (building in buildings) {
        sb.append("$building ")
    }
    print(sb)
}
