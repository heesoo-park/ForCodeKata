import java.io.*;
import java.util.*;

public class Main {
    
    static int[] road = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int n, k;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        bfs();
        
        bw.write(String.valueOf(road[k]));
        bw.flush();
        bw.close();
    }
    
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;
        q.offer(n);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == k) break;
            
            int prevStep = cur - 1;
            if (prevStep >= 0 && !visited[prevStep]) {
                visited[prevStep] = true;
                road[prevStep] = road[cur] + 1;
                q.offer(prevStep);
            } 
            
            int nextStep = cur + 1;
            if (nextStep <= 100000 && !visited[nextStep]) {
                visited[nextStep] = true;
                road[nextStep] = road[cur] + 1;
                q.offer(nextStep);
            } 
            
            int doubleStep = 2 * cur;
            if (doubleStep <= 100000 && !visited[doubleStep]) {
                visited[doubleStep] = true;
                road[doubleStep] = road[cur] + 1;
                q.offer(doubleStep);
            }
        }
    }
}
