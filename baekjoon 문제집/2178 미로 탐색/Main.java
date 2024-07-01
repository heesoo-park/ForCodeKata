import java.io.*;
import java.util.*;

public class Main {
    
    static char[][] maze = new char[101][101];
    static int[][] history = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                maze[i][j] = line.charAt(j - 1);
            }
        }
        
        bfs();
        
        bw.write(String.valueOf(history[n][m]));
        bw.flush();
        bw.close();
    }
    
    static void bfs() {
        
        Queue<Position> q = new LinkedList<>();
        history[1][1] = 1;
        visited[1][1] = true;
        q.offer(new Position(1, 1));
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int newR = cur.r + dy[i];
                int newC = cur.c + dx[i];
                
                if (newR > n || newR < 1 || newC > m || newC < 1) continue;
                if (maze[newR][newC] == '0' || visited[newR][newC]) continue;
                
                history[newR][newC] = history[cur.r][cur.c] + 1;
                visited[newR][newC] = true;
                q.offer(new Position(newR, newC));
            }
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
