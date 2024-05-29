import java.io.*
import java.util.*

private lateinit var graph: Array<MutableList<Int>>
private lateinit var visited: BooleanArray
private val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    val (n, m, v) = br.readLine().split(' ').map { it.toInt() }
    graph = Array(n + 1) { mutableListOf<Int>() }
    
    repeat(m) {
        val (s, e) = br.readLine().split(' ').map { it.toInt() }
        graph[s].add(e)
        graph[e].add(s)
    }
    
    for (i in graph) {
        i.sort()
    }
    
    visited = BooleanArray(n + 1)
    dfs(v)
    
    bw.write("\n")
    
    visited = BooleanArray(n + 1)
    bfs(v)
    
    bw.flush()
    bw.close()
}

fun dfs(start: Int) {
    visited[start] = true
    bw.write("$start ")
    
    for (i in graph[start]) {
        if (!visited[i]) {
            dfs(i)
        }
    }
}

fun bfs(start: Int) {
    val q = ArrayDeque<Int>()
    q.add(start)
    visited[start] = true
    
    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        bw.write("$cur ")
        
        for (i in graph[cur]) {
            if (!visited[i]) {
                visited[i] = true
                q.add(i)
            }
        }
    }
}
