import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[n + 1];
        int[] list = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[1] = list[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + list[i];
        }
        
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            int sum = dp[right] - dp[left - 1];
            bw.write(sum + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
