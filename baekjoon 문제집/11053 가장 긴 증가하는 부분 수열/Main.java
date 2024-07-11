import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0;
        
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                
                max = Math.max(max, dp[i]);
            }
        }
        
        System.out.print(max);
    }
}
