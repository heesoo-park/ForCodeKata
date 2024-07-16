import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        long[] dp = new long[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 41; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        
        int prev = 0;
        long result = 1;
        while (m-- > 0) {
            int ticket = Integer.parseInt(br.readLine());
            result *= dp[ticket - prev - 1];
            prev = ticket;
        }
        
        result *= dp[n - prev];
        System.out.print(result);
    }
}
