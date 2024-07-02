import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[] floor = new boolean[1000001];
    static int[] check = new int[1000001];
    static boolean isFinish = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        bfs(f, s, g, u, d);
        
        bw.write(isFinish ? String.valueOf(check[g]) : "use the stairs");
        bw.flush();
        bw.close();
    }
    
    static void bfs(int height, int start, int goal, int up, int down) {
        Queue<Integer> q = new LinkedList<>();
        floor[start] = true;
        q.offer(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == goal) {
                isFinish = true;
                break;
            }
            
            int nextUp = cur + up;
            if (nextUp <= height && !floor[nextUp]) {
                floor[nextUp] = true;
                check[nextUp] = check[cur] + 1;
                q.offer(nextUp);
            }
            
            int nextDown = cur - down;
            if (nextDown > 0 && !floor[nextDown]) {
                floor[nextDown] = true;
                check[nextDown] = check[cur] + 1;
                q.offer(nextDown);
            }
        }
    }
}
