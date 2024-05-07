import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val (s1, s2, s3) = readln().split(' ').map { it.toInt() }.sortedDescending()
        if (s1 == 0 && s2 == 0 && s3 == 0) break

        when {
            s1 >= s2 + s3 -> bw.write("Invalid\n")
            s1 == s2 && s2 == s3 -> bw.write("Equilateral\n")
            s1 == s2 && s2 != s3 || s2 == s3 && s3 != s1 || s3 == s1 && s1 != s2 -> bw.write("Isosceles\n")
            else -> bw.write("Scalene\n")
        }
    }

    bw.flush()
    bw.close()
}
