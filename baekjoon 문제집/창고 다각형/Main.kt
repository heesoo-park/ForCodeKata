import java.io.*
import java.util.*

// 기둥 정보 저장하는 data class
data class Pillar(
    val pos: Int,
    val height: Int
) {
    companion object {
        fun makePillar(list: List<Int>) = Pillar(list[0], list[1])
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val n = br.readLine().toInt()
    val storage = mutableListOf<Pillar>()
    val stack = Stack<Pillar>()
    var result = 0
    
    // 1. 기둥 저장
    repeat(n) {
        storage.add(Pillar.makePillar(br.readLine().split(' ').map { it.toInt() }))
    }
    
    // 2. 기둥 정렬(위치 기준 오름차순)
    storage.sortBy { it.pos }
    
    // 3. 가장 높은 기둥의 인덱스 찾기
    var idx = 0
    for (i in storage.indices) {
        if (storage[idx].height < storage[i].height) idx = i
    }
    result += storage[idx].height
    
    // 4. 가장 높은 기둥 왼쪽 계산
    for (i in 0 until idx) {
        if (stack.isEmpty()) {
            stack.push(storage[i])
            continue
        }
        
        if (stack.peek().height < storage[i].height) {
            stack.push(storage[i])
        }
    }
    
    var prev = storage[idx]
    while (stack.isNotEmpty()) {
        val cur = stack.pop()
        result += (cur.height * (prev.pos - cur.pos))
        prev = cur
    }
    
    // 5. 가장 높은 기둥 오른쪽 계산
    for (i in storage.lastIndex downTo idx + 1) {
        if (stack.isEmpty()) {
            stack.push(storage[i])
            continue
        }
        
        if (stack.peek().height < storage[i].height) {
            stack.push(storage[i])
        }
    }
    
    prev = storage[idx]
    while (stack.isNotEmpty()) {
        val cur = stack.pop()
        result += (cur.height * (cur.pos - prev.pos))
        prev = cur
    }
    
    bw.write("$result\n")
    bw.flush()
    bw.close()
}
