import java.io.*
import java.util.*
import kotlin.math.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    val t = br.readLine().toInt()
    repeat(t) {
        // n : 팀의 개수
        // k : 문제의 개수
        // t : 당신 팀의 ID
        // m : 로그 엔트리의 개수
        val (n, k, t, m) = br.readLine().split(' ').map { it.toInt() }
        
        val table = Array(n + 1) { IntArray(k + 1) { 0 } }
        val submitCnt = Array(n + 1) { 0 }
        val lastSubmit = Array(n + 1) { 0 }
        for (l in 0 until m) {
            // i : 팀 ID
            // j : 문제 번호
            // s : 획득한 점수
            val (i, j, s) = br.readLine().split(' ').map { it.toInt() }
            table[i][j] = maxOf(table[i][j], s)
            submitCnt[i]++
            lastSubmit[i] = l
        }
        
        val targetScore = table[t].sum()
        var rank = 1
        for (l in 1..n) {
            if (l == t) continue
            
            if (table[l].sum() > targetScore) {
                rank++
            } else if (table[l].sum() == targetScore) {
                if (submitCnt[l] < submitCnt[t]) {
                    rank++
                } else if (submitCnt[l] == submitCnt[t]) {
                    if (lastSubmit[l] < lastSubmit[t]) {
                        rank++
                    }
                }
            } 
        }
        
        println(rank)
    }
}
