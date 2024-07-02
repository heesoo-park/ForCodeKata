import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] region = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max = 0;
        
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < 101; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (region[j][k] - i > 0 && !visited[j][k]) {
                        cnt++;
                        bfs(j, k, i);
                    }
                }
            }
            
            if (cnt == 0) break;
            
            max = Math.max(max, cnt);
            clearArray();
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
    
    static void bfs(int sr, int sc, int depth) {
        Queue<Position> q = new LinkedList<>();
        visited[sr][sc] = true;
        q.offer(new Position(sr, sc));
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dy[i];
                int nc = cur.c + dx[i];
                
                if (nr >= n || nr < 0 || nc >= n || nc < 0) continue;
                if (region[nr][nc] - depth <= 0 || visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                q.offer(new Position(nr, nc));
            }
        }
    }
    
    static void clearArray() {
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
