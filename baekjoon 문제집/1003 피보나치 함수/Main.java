import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][] dp = new int[41][2];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            sb.append(dp[n][0]).append(' ').append(dp[n][1]).append("\n");
        }
        
        System.out.print(sb);
    }
}
