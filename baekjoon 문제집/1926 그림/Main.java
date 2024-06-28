import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] paper = new int[501][501];
    static boolean[][] visited = new boolean[501][501];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    int curArea = bfs(i, j);
                    maxArea = Math.max(maxArea, curArea);
                    cnt++;
                }
            }
        }
        
        bw.write(String.valueOf(cnt) + "\n");
        bw.write(String.valueOf(maxArea));
        bw.flush();
        bw.close();
    }
    
    private static int bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        int area = 1;
        
        visited[row][col] = true;
        q.offer(new Point(row, col));
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int newRow = cur.r + dy[i];
                int newCol = cur.c + dx[i];
                
                if (newRow >= n || newRow < 0 || newCol >= m || newCol < 0) continue;
                if (visited[newRow][newCol]) continue;
                if (paper[newRow][newCol] == 0) continue;
                
                visited[newRow][newCol] = true;
                area++;
                q.offer(new Point(newRow, newCol));
            }
        }
        
        return area;
    }
    
    static class Point {
        int r;
        int c;
    
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
