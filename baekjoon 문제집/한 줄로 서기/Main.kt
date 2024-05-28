import java.io.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val info = br.readLine().split(' ').map { it.toInt() }
    val line = IntArray(n)

    info.forEachIndexed { idx, num ->
        var cnt = 0
        var i = 0
        while (true) {
            if (cnt == num) {
                while (line[i] != 0) {
                    i++
                }
                line[i] = idx + 1
                break
            }

            if (line[i] == 0) {
                while(line[i + 1] != 0) {
                    i++
                }
                cnt++
            }

            i++
        }
    }
    
    line.forEach {
        bw.write("$it ")
    }
    bw.flush()
    bw.close()
}
