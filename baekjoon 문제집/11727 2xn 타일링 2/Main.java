import java.io.*;
import java.util.*;

public class Main {
    
    private static long[] dp = new long[1001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < 1001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        
        int n = Integer.parseInt(br.readLine());
        System.out.print(dp[n]);
    }
}
