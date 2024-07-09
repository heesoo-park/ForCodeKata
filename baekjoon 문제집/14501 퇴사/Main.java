import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] schedule = new int[n + 1][2];
        int[] dp = new int[n + 2];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= n; i++) {
            int nextDay = i + schedule[i][0];
            
            if (nextDay <= n + 1) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + schedule[i][1]);
            }
            
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        
        System.out.print(dp[n + 1]);
    }
}
