import java.io.*;
import java.util.*;

public class Main {
    
    private static long[][] dp = new long[101][11];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;            
        }
        
        for (int i = 2; i < 101; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j + 1];
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        
        long sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += dp[n][i];
        }
        System.out.print(sum % 1000000000);
    }
}
