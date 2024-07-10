class Solution {
    fun solution(s: String, n: Int): String {
        val cal = s.toCharArray()
        for (i in cal.indices) {
            if (cal[i] != ' ') {
                if (cal[i] <= 'Z') {
                    if (cal[i] + n in 'A'..'Z') {
                        cal[i] = (cal[i] + n)
                    } else {
                        cal[i] = (cal[i] - (26 - n))
                    }
                } else if (cal[i] <= 'z') {
                    if (cal[i] + n in 'a'..'z') {
                        cal[i] = (cal[i] + n)
                    } else {
                        cal[i] = (cal[i] - (26 - n))
                    }
                }

            }
        }
        return cal.joinToString("")
    }
}
