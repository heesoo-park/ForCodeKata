class Solution {
    fun solution(food: IntArray): String {
        var playerFood = intArrayOf()
        
        for (i in 1 until food.size) {
            for (j in 0 until food[i] / 2) {
                playerFood += i;
            }
        }
        return playerFood.joinToString("") + "0" + playerFood.reversed().joinToString("")
    }
}
