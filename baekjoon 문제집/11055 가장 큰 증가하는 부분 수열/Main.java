import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
                
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = nums[i];
        }
        
        for (int i = 1; i <=n; i++) {
            max = Math.max(max, dp[i]);
            
            for (int j = 1; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                if (dp[j] + nums[i] <= dp[i]) continue;
                
                dp[i] = dp[j] + nums[i];
                max = Math.max(max, dp[i]);
            }
        }
        
        System.out.print(max);
    }
}
