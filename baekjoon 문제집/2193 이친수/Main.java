import java.io.*;
import java.util.*;

public class Main {
    
    private static long[] dp = new long[91];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < 91; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        int n = Integer.parseInt(br.readLine());
        System.out.print(dp[n]);
    }
}
