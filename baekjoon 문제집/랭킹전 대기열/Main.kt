import java.io.*
import java.util.*

data class Player(
    val level: Int,
    val id: String
) {
    companion object {
        fun makePlayer(info: List<String>): Player {
            return Player(info[0].toInt(), info[1])
        }
    }
}

val rooms: MutableList<MutableList<Player>> = mutableListOf()

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val (p, m) = br.readLine().split(' ').map { it.toInt() }
    
    repeat(p) {
        val player = Player.makePlayer(br.readLine().split(' '))
        if (rooms.isEmpty()) {
            rooms.add(mutableListOf(player))
        } else {
            var flag = false
            for (i in rooms.indices) {
                if (rooms[i].size < m && rooms[i][0].level in player.level - 10..player.level + 10) {
                    rooms[i].add(player)
                    flag = true
                    break
                }
            }
            
            if (!flag) {
                rooms.add(mutableListOf(player))
            }
        }
    }
    
    rooms.forEach { room ->
        if (room.size == m) bw.write("Started!\n")
        else bw.write("Waiting!\n")
        
        val sortedRoom = room.sortedBy { it.id }
        
        sortedRoom.forEach { member ->
            bw.write("${member.level} ${member.id}\n")    
        }
    }
    
    bw.flush()
    bw.close()
}
