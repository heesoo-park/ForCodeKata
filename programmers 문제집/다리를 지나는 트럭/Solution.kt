import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val position = LinkedList<Pos>()
        var currentWeight = weight
        var currentLength = bridge_length

        var num = 0
        while (num != truck_weights.size) {
            if (position.size != 0) {
                if (position[0].second == bridge_length) {
                    currentLength += 1
                    currentWeight += position[0].first
                    position.pollFirst()
                }
            }

            val currentTruck = truck_weights[num]
            if (currentWeight >= currentTruck && currentLength > 0) {
                position.forEach {
                    it.second += 1
                }
                position.add(Pos(currentTruck, 1))
                currentWeight -= currentTruck
                currentLength -= 1
                num++
            } else {
                position.forEach {
                    it.second += 1
                }
            }

            answer++
        }


        while (position.size != 0) {
            position.forEach {
                it.second += 1
            }
            if (position[0].second > bridge_length) {
                currentLength += 1
                currentWeight += position[0].first
                position.pollFirst()
            }

            answer++
        }

        return answer
    }
    
    data class Pos(var first:Int, var second: Int)
}

// 두 케이스 실패한 코드
import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val position = LinkedList<Pos>()
        var currentWeight = weight
        var currentLength = bridge_length

        var num = 0
        while (num != truck_weights.size) {
            answer++
            val currentTruck = truck_weights[num]
            if (currentWeight >= currentTruck && currentLength > 0) {
                position.forEach {
                    it.second += 1
                }
                position.add(Pos(currentTruck, 1))
                currentWeight -= currentTruck
                currentLength -= 1
                num++
            } else {
                position.forEach {
                    it.second += 1
                }
                if (position[0].second > bridge_length) {
                    currentLength += 1
                    currentWeight += position[0].first
                    position.pollFirst()

                    if (currentWeight >= currentTruck && currentLength > 0) {
                        position.add(Pos(currentTruck, 1))
                        currentWeight -= currentTruck
                        currentLength -= 1
                        num++
                    }
                }
            }
        }

        while (position.size != 0) {
            position.forEach {
                it.second += 1
            }
            if (position[0].second > bridge_length) {
                currentLength += 1
                currentWeight += position[0].first
                position.pollFirst()
            }

            answer++
        }
        
        return answer
    }
    
    data class Pos(var first:Int, var second: Int)
}
