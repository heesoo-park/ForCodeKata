import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[] dp = new boolean[1001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        for (int i = 5; i < 1001; i++) {
            if (dp[i - 1] && dp[i - 3] && dp[i - 4]) {
                dp[i] = false;
            } else {
                dp[i] = true;
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        System.out.print(dp[n] ? "SK" : "CY");
    }
}
