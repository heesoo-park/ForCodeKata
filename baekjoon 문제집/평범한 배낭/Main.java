import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Thing[] list = new Thing[n + 1];
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[i] = new Thing(w, v);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (list[i].weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list[i].weight] + list[i].value);
                }
            }
        }
        
        System.out.print(dp[n][k]);
    }
    
    public static class Thing {
        int weight;
        int value;
        
        public Thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
