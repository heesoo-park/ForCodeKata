class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        var personalityType = mutableMapOf<Char, Int>(
            'R' to 0,
            'T' to 0,
            'C' to 0,
            'F' to 0,
            'J' to 0,
            'M' to 0,
            'A' to 0,
            'N' to 0)

        survey.forEachIndexed { index, s ->
            when (choices[index]) {
                1 -> personalityType[s[0]] = personalityType[s[0]]!! + 3
                2 -> personalityType[s[0]] = personalityType[s[0]]!! + 2
                3 -> personalityType[s[0]] = personalityType[s[0]]!! + 1
                5 -> personalityType[s[1]] = personalityType[s[1]]!! + 1
                6 -> personalityType[s[1]] = personalityType[s[1]]!! + 2
                7 -> personalityType[s[1]] = personalityType[s[1]]!! + 3
            }
        }

        answer += if (personalityType['R']!! >= personalityType['T']!!) "R" else "T"
        answer += if (personalityType['C']!! >= personalityType['F']!!) "C" else "F"
        answer += if (personalityType['J']!! >= personalityType['M']!!) "J" else "M"
        answer += if (personalityType['A']!! >= personalityType['N']!!) "A" else "N"

        return answer
    }
}
