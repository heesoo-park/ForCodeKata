class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: Array<String> = players
        var playerToRank = mutableMapOf<String, Int>()
        var rankToPlayer = mutableMapOf<Int, String>()

        players.forEachIndexed { index, s ->
            playerToRank[s] = index
            rankToPlayer[index] = s
        }

        for (call in callings) {
            val curRank: Int = playerToRank[call]!!
            val frontPlayer: String = rankToPlayer[curRank - 1]!!
            answer[curRank] = answer[curRank - 1].also { answer[curRank - 1] = answer[curRank] }
            playerToRank[call] = curRank - 1
            playerToRank[frontPlayer] = curRank
            rankToPlayer[curRank - 1] = call
            rankToPlayer[curRank] = frontPlayer
        }

        return answer
    }
}

// Map을 썼지만 시간초과 난 코드
// fun solution(players: Array<String>, callings: Array<String>): Array<String> {
//         var answer: Array<String> = arrayOf<String>()
//         var curRank = mutableMapOf<String, Int>()

//         players.forEachIndexed { index, s ->
//             curRank[s] = index + 1
//         }

//         for (call in callings) {
//             val playerCurRank: Int = curRank[call]!!
//             val frontPlayer = curRank.filter { it.value == (playerCurRank - 1) }.keys.first()

//             curRank[call] = curRank[call]!! - 1
//             curRank[frontPlayer] = curRank[frontPlayer]!! + 1
//         }

//         curRank.toList().sortedBy { it.second }.forEach {
//             answer += it.first
//         }
//         return answer

// 2중 for문 안 될 거 같아도 해봤지만 시간초과 난 코드
// fun solution(players: Array<String>, callings: Array<String>): Array<String> {
//         var answer: Array<String> = players
        
//         for (call in callings) {
//             for (index in answer.indices) {
//                 if (answer[index] == call) {
//                     answer[index] = answer[index - 1].also { answer[index - 1] = answer[index] }
//                     break
//                 }
//             }
//         }

//         return answer
//     }
