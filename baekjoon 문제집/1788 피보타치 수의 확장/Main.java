import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int absN = Math.abs(n);
        
        if (n == 0) {
            sb.append(0).append("\n").append(0);
            System.out.print(sb);
            return;
        }
        
        long[] dp = new long[Math.abs(absN) + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= absN; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
        }
        
        if (n < 0) {
            if (absN % 2 == 0) {
                sb.append(-1).append("\n");
            } else {
                sb.append(1).append("\n");
            }
        } else {
            sb.append(1).append("\n");
        }
        sb.append(dp[absN]);
        
        System.out.print(sb);
    }
}
