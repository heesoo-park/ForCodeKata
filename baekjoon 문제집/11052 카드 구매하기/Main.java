// 탑다운 방식
import java.io.*;
import java.util.*;

public class Main {
    private static int[] price = new int[1001];
    private static int[] dp = new int[1001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.print(solve(n));
    }
    
    static int solve(int n) {
        if (dp[n] > 0) return dp[n];
        
        for (int i = 1; i <= n; i++) {
            dp[n] = Math.max(dp[n], solve(n - i) + price[i]);
        }
        
        return dp[n];
    }
}

// 바텀업 방식
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] price = new int[n + 1];
        int[] dp = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            dp[i] = price[i];
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + price[i - j]);
            }
        }
        
        System.out.print(dp[n]);
    }
}
