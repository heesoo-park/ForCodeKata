import java.io.*
import java.util.*

data class Pos(
    val x: Int,
    val y: Int
)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    val (n, m, l, k) = br.readLine().split(' ').map { it.toInt() }
    val stars = mutableListOf<Pos>()
    var result = 0
    
    for (i in 0 until k) {
        val star = br.readLine().split(' ').map { it.toInt() }
        stars.add(Pos(star[0], star[1]))
    }
    
    for (i in stars) {
        for (j in stars) {
            val row = i.x
            val col = j.y
            
            var defence = 0
            for (s in stars) {
                if (s.x >= row && s.x <= row + l && s.y >= col && s.y <= col + l) defence++
            }
            
            result = maxOf(result, defence)
        }
    }
    
    print(k - result)
}
