import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] board = new int[301][301];
    static boolean[][] visited = new boolean[301][301];
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {           
            int l = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int targetR = Integer.parseInt(st.nextToken());
            int targetC = Integer.parseInt(st.nextToken());
            
            bfs(l, new Position(startR, startC), new Position(targetR, targetC));
            bw.write(String.valueOf(board[targetR][targetC]) + "\n");
            
            cleanBoard();
        }
        
        bw.flush();
        bw.close();
    }
    
    static void bfs(int len, Position start, Position target) {
        Queue<Position> q = new LinkedList<>();
        visited[start.r][start.c] = true;
        q.offer(start);
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            
            if (cur.r == target.r && cur.c == target.c) break;
            
            for (int i = 0; i < 8; i++) {
                int newR = cur.r + dy[i];
                int newC = cur.c + dx[i];
                
                if (newR >= len || newR < 0 || newC >= len || newC < 0) continue;
                if (visited[newR][newC]) continue;
                
                visited[newR][newC] = true;
                board[newR][newC] = board[cur.r][cur.c] + 1;
                q.offer(new Position(newR, newC));
            }
        }
    }
    
    static void cleanBoard() {
        for (int[] line : board) {
            Arrays.fill(line, 0);
        }
        
        for (boolean[] line : visited) {
            Arrays.fill(line, false);
        }
    }
    
    static class Position {
        int r, c;
        
        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
