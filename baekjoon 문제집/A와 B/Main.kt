fun main() = with(System.`in`.bufferedReader()) {
    val s = StringBuilder(readln())
    val t = StringBuilder(readln())

    while (s.length != t.length) {
        val lastIndex = t.lastIndex
        when (t[lastIndex]) {
            'A' -> {
                t.deleteCharAt(lastIndex)
            }
            'B' -> {
                t.deleteCharAt(lastIndex).reverse()
            }
        }
    }

    println(
        if (s.toString() == t.toString()) 1 else 0
    )
}
