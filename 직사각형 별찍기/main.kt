fun main(args: Array<String>) {
    val (n, m) = readln().split(" ").map{it.toInt()}

    for (i in 0 until m) {
        for (j in 0 until n) {
            print("*")
        }
        print("\n")
    }
}
