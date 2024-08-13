import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] event = new int[t + 1];
        int[][][] dp = new int[3][t + 1][w + 2];
        int answer = 0;
        
        for (int i = 1; i <= t; i++) {
            event[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= w + 1; j++) {
                if (event[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
                } else {
                    if (i == 1 && j == 1) continue;
                    
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1] + 1, dp[2][i - 1][j] + 1);
                }
            }
        }
        
        for (int i = 1; i <= w + 1; i++) {
            answer = Math.max(dp[1][t][i], dp[2][t][i]);
        }
        
        System.out.println(answer);
    }
}
