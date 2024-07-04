import java.io.*;
import java.util.*;

public class Main {
    
    static long[] dp = new long[1001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        dp[1] = 1L;
        dp[2] = 2L;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }
        
        System.out.print(dp[n]);
    }
}
