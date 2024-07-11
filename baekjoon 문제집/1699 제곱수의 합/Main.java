import java.io.*;
import java.util.*;

public class Main {
    
    private static int[] dp = new int[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        for (int i = 5; i < 100001; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); 
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        System.out.print(dp[n]);
    }
}
