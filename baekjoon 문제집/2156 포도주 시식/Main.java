// 바텀업 방식
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] glass = new int[n + 1];
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            glass[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = glass[1];
        
        if (n == 1) {
            System.out.print(dp[1]);
            return;
        }
        
        dp[2] = glass[1] + glass[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], glass[i - 1] + dp[i - 3]) + glass[i]);
        }
        
        System.out.print(Arrays.stream(dp).max().getAsInt());
    }
}
