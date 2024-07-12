// 바텀업 방식
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n + 1];        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        
        sb.append(dp[n]).append("\n");
        sb.append(n).append(' ');
        while (n > 1) {
            if (n % 3 == 0 && dp[n] == dp[n / 3] + 1) {
                sb.append(n / 3).append(' ');
                n /= 3;
            } else if (n % 2 == 0 && dp[n] == dp[n / 2] + 1) {
                sb.append(n / 2).append(' ');
                n /= 2;
            } else {
                sb.append(n - 1).append(' ');
                n -= 1;
            }
        }
        
        System.out.print(sb);
    }
}
