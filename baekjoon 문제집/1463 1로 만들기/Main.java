// 조금 더 빠른 코드
import java.io.*;
import java.util.*;

public class Main {
    
    static int[] dp = new int[1000001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        
        System.out.print(String.valueOf(dp[n]));
    }
}


import java.io.*;
import java.util.*;

public class Main {
    
    static int[] dp = new int[1000001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(dp, 1000000);
        
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        
        System.out.print(String.valueOf(dp[n]));
    }
}
