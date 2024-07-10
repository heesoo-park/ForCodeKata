class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var curPoint = mutableListOf(-1, -1)

        for (row in park.indices) {
            for (col in park[0].indices) {
                if (park[row][col] == 'S') {
                    curPoint = mutableListOf(row, col)
                    break
                }
            }
            if (curPoint[0] != -1) break
        }

        for (route in routes) {
            var op = route[0]
            var n = route[2] - '0'
            var containX = false

            if (op == 'N') {
                if (curPoint[0] - n < 0) continue
                
                for (index in curPoint[0] - n..curPoint[0]) {
                    if (park[index][curPoint[1]] == 'X') {
                        containX = true
                        break
                    }
                }
                if (containX) continue
                curPoint[0] -= n
            }
            else if (op == 'S') {
                if (curPoint[0] + n >= park.size) continue

                for (index in curPoint[0]..curPoint[0] + n) {
                    if (park[index][curPoint[1]] == 'X') {
                        containX = true
                        break
                    }
                }
                if (containX) continue
                curPoint[0] += n
            }
            else if (op == 'W') {
                if (curPoint[1] - n < 0) continue

                for (index in curPoint[1] - n..curPoint[1]) {
                    if (park[curPoint[0]][index] == 'X') {
                        containX = true
                        break
                    }
                }
                if (containX) continue
                curPoint[1] -= n
            }
            else if (op == 'E') {
                if (curPoint[1] + n >= park[0].length) continue
                for (index in curPoint[1]..curPoint[1] + n) {
                    if (park[curPoint[0]][index] == 'X') {
                        containX = true
                        break
                    }
                }
                if (containX) continue
                curPoint[1] += n
            }
        }
        
        return curPoint.toIntArray()
    }
}
