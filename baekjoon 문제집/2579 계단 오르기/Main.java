import java.io.*;
import java.util.*;

public class Main {
    
    static int[] scores = new int[301];
    static int[] dp = new int[301];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = scores[1];
        
        if (n == 1) {
            System.out.print(String.valueOf(dp[1]));
            return;
        }
        
        dp[2] = scores[1] + scores[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], scores[i - 1] + dp[i - 3]) + scores[i];
        }
        
        System.out.print(String.valueOf(dp[n]));
    }
}
