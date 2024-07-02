import java.io.*;
import java.util.*;

public class Main {
    
    static char[][] map = new char[26][26];
    static boolean[][] visited = new boolean[26][26];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        
        bw.write(cnt + "\n");
        Collections.sort(list);
        for (int num : list) {
            bw.write(num + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    static void bfs(int sr, int sc) {
        Queue<Position> q = new LinkedList<>();
        int area = 1;
        visited[sr][sc] = true;
        q.offer(new Position(sr, sc));
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dy[i];
                int nc = cur.c + dx[i];
                
                if (nr >= n || nr < 0 || nc >= n || nc < 0) continue;
                if (map[nr][nc] == '0' || visited[nr][nc]) continue;
                
                area++;
                visited[nr][nc] = true;
                q.offer(new Position(nr, nc));
            }
        }
        
        list.add(area);
    }
    
    static class Position {
        int r;
        int c;
        
        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
