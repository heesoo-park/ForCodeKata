// 탑다운 방식
import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][] cost = new int[1001][3];
    private static int[][] dp = new int[1001][3];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());            
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        
        System.out.print(Math.min(paintHouse(n, 0), Math.min(paintHouse(n, 1), paintHouse(n, 2))));
    }
    
    static int paintHouse(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == 0) {
                dp[n][color] = Math.min(paintHouse(n - 1, 1), paintHouse(n - 1, 2)) + cost[n][color];
            } else if (color == 1) {
                dp[n][color] = Math.min(paintHouse(n - 1, 0), paintHouse(n - 1, 2)) + cost[n][color];
            } else {
                dp[n][color] = Math.min(paintHouse(n - 1, 0), paintHouse(n - 1, 1)) + cost[n][color];
            }
        }
        
        return dp[n][color];
    }
}


// 바텀업 방식
import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][] cost = new int[1001][3];
    private static int[][] dp = new int[1001][3];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());            
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }
        
        int result = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.print(result);
    }
}
