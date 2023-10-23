class Solution {
    fun solution(s: String): String {
        return s.split(" ").joinToString(" ") { word ->
            word.mapIndexed { idx, c ->
                if (idx % 2 == 0) c.uppercase()
                else c.lowercase()
            }.joinToString("")
        }
    }
}

// "kotlin.Unit kotlin.Unit kotlin.Unit" 이라고 나오는 코드
// class Solution {
//     fun solution(s: String): String {
//         return s.split(" ").map{
//             for ((idx, c) in it.withIndex()) {
//                 if (idx % 2 == 0) {
//                     c.uppercaseChar()
//                 }
//                 else {
//                     c.lowercaseChar()
//                 }
//             } }.joinToString(" ")
//     }
// }
