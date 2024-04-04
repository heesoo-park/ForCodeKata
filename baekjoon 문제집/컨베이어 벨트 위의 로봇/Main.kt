fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readln().split(' ').map { it.toInt() }
    // 컨베이어 벨트의 내구도를 저장하는 변수
    val conveyorBelt = readln().split(' ').map { it.toInt() }.toMutableList()
    // 현재 로봇의 위치를 저장하는 변수
    val visited = Array(n * 2) { false }
    var result = 0

    while (true) {
        // 한 사이클마다 단계 1씩 상승
        result++

        // 단계 1. 컨베이어벨트와 로봇 회전방향으로 한칸씩 움직이기
        val tempBelt = conveyorBelt[n * 2 - 1]
        val tempVisit = visited[n * 2 - 1]
        for (i in n * 2 - 1 downTo 1) {
            conveyorBelt[i] = conveyorBelt[i - 1]
            visited[i] = visited[i - 1]
        }
        conveyorBelt[0] = tempBelt
        visited[0] = tempVisit

        // 내리는 위치에 로봇이 있다면 내리기
        if (visited[n - 1]) {
            visited[n - 1] = false
        }

        // 단계 2. 로봇만 따로 조건에 맞춰 회전방향으로 한칸씩 움직이기
        for (i in n - 2 downTo 0) {
            if (!visited[i]) continue

            if (conveyorBelt[i + 1] > 0 && !visited[i + 1]) {
                conveyorBelt[i + 1]--
                visited[i] = false
                visited[i + 1] = true
            }
        }

        // 내리는 위치에 로봇이 있다면 내리기
        if (visited[n - 1]) {
            visited[n - 1] = false
        }

        // 단계 3. 올리는 위치가 비어있다면 로봇을 올리기
        if (conveyorBelt[0] > 0 && !visited[0]) {
            conveyorBelt[0]--
            visited[0] = true
        }

        // 단계 4. 내구도가 0인 칸의 개수가 k개를 넘을 시 종료
        if (conveyorBelt.count { it == 0 } >= k) break
    }

    println(result)
}


// 문제를 잘못 이해한 거였다...
// 어쩐지 예제랑 안 맞더라...
import java.util.LinkedList

data class Robot(
    val id: Int,
    val pos: Int
) {
    companion object {
        fun lastCycleData(): Robot = Robot(0, 0)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val conveyorBelt = readln().split(' ').map { it.toInt() }.toMutableList()
    val visited = Array(n * 2) { false }
    val currentPos = LinkedList<Robot>()
    var result = 1
    var id = 1

    if (conveyorBelt[0] != 0) {
        visited[0] = true
        currentPos.add(Robot(id++, 0))
    }

    while (currentPos.isNotEmpty()) {
        val cur = currentPos.poll() ?: Robot.lastCycleData()

        if (cur.pos == n * 2 - 1) {
            if (conveyorBelt[0] > 0 && !visited[0]) {
                conveyorBelt[0]--
                visited[0] = true
                visited[cur.pos] = false
                currentPos.add(Robot(cur.id, 0))
            }
        } else {
            if (conveyorBelt[cur.pos + 1] > 0 && !visited[cur.pos + 1]) {
                conveyorBelt[cur.pos + 1]--
                visited[cur.pos + 1] = true
                visited[cur.pos] = false
                currentPos.add(Robot(cur.id, cur.pos + 1))
            }
        }

        if (conveyorBelt[0] > 0 && !visited[0]) {
            conveyorBelt[0]--
            visited[0] = true
            currentPos.add(Robot(id++, 0))
        }

        if (conveyorBelt.count { it == 0 } >= k) break

        result++
    }

    println(result)
}


// 두번째 예제 틀린 코드
fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val conveyorBelt = readln().split(' ').map { it.toInt() }.toMutableList()
    val currentPos = Array(n * 2) { false }
    var result = 0

    while (conveyorBelt.count { it == 0 } < k) {
        for (pos in n * 2 - 1 downTo 0) {
            if (pos == n * 2 - 1 && currentPos[pos]) {
                currentPos[pos] = false
            } else if (currentPos[pos] && !currentPos[pos + 1] && conveyorBelt[pos + 1] > 0) {
                conveyorBelt[pos + 1]--
                currentPos[pos + 1] = true
                currentPos[pos] = false
            }
        }

        if (!currentPos[0] && conveyorBelt[0] > 0) {
            conveyorBelt[0]--
            currentPos[0] = true
        }

        if (conveyorBelt.count { it == 0 } >= k) break

        result++
    }

    println(result)
}
