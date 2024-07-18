// 탑다운 방식
import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][] dp = new int[1001][10];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < 10; i++) {
            dp[1][i] = i + 1;
        }
        
        System.out.print(solve(n, 9));
    }
    
    static int solve(int n, int idx) {
        if (n == 1 || dp[n][idx] != 0) return dp[n][idx];
        
        if (idx == 0) dp[n][idx] = solve(n - 1, 9);
        else dp[n][idx] = (solve(n, idx - 1) + solve(n - 1, 9) - solve(n - 1, idx - 1) + 10007) % 10007;
        
        return dp[n][idx];
    }
}


// 바텀업 방식
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long[][] dp = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = i + 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][9];
                else dp[i][j] = (dp[i][j - 1] + dp[i - 1][9] - dp[i - 1][j - 1] + 10007) % 10007;
            }
        }
        
        System.out.print(dp[n][9] % 10007);
    }
}
