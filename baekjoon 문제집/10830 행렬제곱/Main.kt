import java.io.*
import java.util.*

var matrix = Array(5) { LongArray(5) }
var result = Array(5) { i -> LongArray(5) { j -> if (i == j) 1 else 0 } }

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    lateinit var st: StringTokenizer
    val sb = StringBuilder()
    
    st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    var b = st.nextToken().toLong()
    
    for (i in 0 until n) {
        st = StringTokenizer(readLine())
        for (j in 0 until n) {
            matrix[i][j] = st.nextToken().toLong()
        }
    }
    
    while (b > 0) {
        if (b % 2 == 1L) {
            result = mulMatrix(n, 1)
            b--
        } else {
            matrix = mulMatrix(n, 0)
            b /= 2
        }
    }
    
    for (i in 0 until n) {
        for (j in 0 until n) {
            sb.append(result[i][j]).append(' ')
        }
        sb.append('\n')
    }
    
    print(sb)
}

fun mulMatrix(n: Int, type: Int): Array<LongArray> {
    val temp = Array(n) { LongArray(n) }
    
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                if (type == 1) temp[i][j] += matrix[i][k] * result[k][j]
                else temp[i][j] += matrix[i][k] * matrix[k][j]
            }
            
            temp[i][j] = temp[i][j] % 1000
        }
    }
    
    return temp
}
