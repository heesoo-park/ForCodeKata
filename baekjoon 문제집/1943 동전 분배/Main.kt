import java.io.*
import java.util.*

data class Coin(
    val value: Int,
    val count: Int
)

private lateinit var coins: MutableList<Coin>
private lateinit var dp: IntArray

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    
    repeat(3) {
        val n = br.readLine().toInt()
        var sum = 0
        var ans = 0
        
        coins = mutableListOf()
        dp = IntArray(50001)
        
        for (i in 0 until n) {
            val (v, c) = br.readLine().split(' ').map { it.toInt() }
            coins.add(Coin(v, c))
            sum += (v * c)
        } 
        
        if (sum % 2 == 0) {
            dp[0] = 1
            for (i in coins) {
                for (j in 50000 downTo i.value) {
                    if (dp[j - i.value] == 1) {
                        for (k in 0..i.count) {
                            if (j + k * i.value <= 50000) {
                                dp[j + k * i.value] = 1
                            }
                        }
                    }
                }
            }
            
            ans = dp[sum / 2]
        }
        
        sb.append("$ans\n")
    }
    
    print(sb)
}
