// 탑다운 방식
import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][] value;
    private static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int k = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            
            k++;
            value = new int[n + 1][4];
            dp = new int[n + 1][4];
            
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < 4; j++) {
                    value[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            
            dp[1][2] = value[1][2];
            dp[1][3] = value[1][2] + value[1][3];
            sb.append(k).append(". ").append(solve(n, 2)).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int solve(int n, int c) {
        if (n == 1 || dp[n][c] != Integer.MAX_VALUE) return dp[n][c];
        
        if (c == 1) {
            dp[n][1] = Math.min(solve(n - 1, 1), solve(n - 1, 2)) + value[n][1];
        } else if (c == 2) {
            dp[n][2] = Math.min(Math.min(solve(n - 1, 1), solve(n - 1, 2)), Math.min(solve(n - 1, 3), solve(n, 1))) + value[n][2];
        } else {
            dp[n][3] = Math.min(Math.min(solve(n - 1, 2), solve(n - 1, 3)), solve(n, 2)) + value[n][3];
        }
        
        return dp[n][c];
    }
}


// 바텀업 방식
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int k = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            
            k++;
            int[][] value = new int[n + 1][4];
            int[][] dp = new int[n + 1][4];
            
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < 4; j++) {
                    value[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dp[1][1] = 10000001;
            dp[1][2] = value[1][2];
            dp[1][3] = value[1][2] + value[1][3];
            for (int i = 2; i <= n; i++) {
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][2]) + value[i][1];
                dp[i][2] = Math.min(Math.min(dp[i - 1][1], dp[i - 1][2]), Math.min(dp[i - 1][3], dp[i][1])) + value[i][2];
                dp[i][3] = Math.min(Math.min(dp[i - 1][2], dp[i - 1][3]), dp[i][2]) + value[i][3];
            }
            
            sb.append(k).append(". ").append(dp[n][2]).append('\n');
        }
        
        System.out.print(sb);
    }
}
