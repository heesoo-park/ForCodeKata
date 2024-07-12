// 탑다운 방식
import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][] triangle;
    private static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        triangle = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 1; i <= n; i++) {
            dp[n][i] = triangle[n][i];
        }
        
        System.out.print(findMaxSum(n, 1, 1));
    }
    
    static int findMaxSum(int n, int depth, int idx) {
        if (depth == n) return dp[depth][idx];
        
        if (dp[depth][idx] == 0) {
            dp[depth][idx] = Math.max(findMaxSum(n, depth + 1, idx), findMaxSum(n, depth + 1, idx + 1)) + triangle[depth][idx];
        }
        
        return dp[depth][idx];
    }
}


// 바텀업 방식
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 1; i <= n; i++) {
            dp[n][i] = triangle[n][i];
        }
        
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        
        System.out.print(dp[1][1]);
    }
}
