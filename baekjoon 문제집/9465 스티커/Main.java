// 바텀업 빙식
import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][] sticker;
    private static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            sticker = new int[2][100001];
            dp = new int[2][100001];
            
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());                    
                }
            }
            
            if (n <= 2) {
                bw.write(Math.max(sticker[0][1] + sticker[1][2], sticker[1][1] + sticker[0][2]) + "\n");
                continue;
            }
            
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            dp[0][2] = sticker[0][2] + sticker[1][1];
            dp[1][2] = sticker[1][2] + sticker[0][1];
            for (int i = 3; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }
            
            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}


// 탑다운 방식
import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][] sticker;
    private static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            sticker = new int[2][100001];
            dp = new int[2][100001];
            
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = -1;                  
                }
            }
            
            if (n <= 2) {
                bw.write(Math.max(sticker[0][1] + sticker[1][2], sticker[1][1] + sticker[0][2]) + "\n");
                continue;
            }
            
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            dp[0][2] = sticker[0][2] + sticker[1][1];
            dp[1][2] = sticker[1][2] + sticker[0][1];
            
            bw.write(Math.max(solve(0, n), solve(1, n)) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    static int solve(int r, int c) {
        if (c <= 2) return dp[r][c];
        if (dp[r][c] >= 0) return dp[r][c];
        
        if (r == 0) {
            dp[r][c] = Math.max(solve(1, c - 1), solve(1, c - 2)) + sticker[r][c];
        } else {
            dp[r][c] = Math.max(solve(0, c - 1), solve(0, c - 2)) + sticker[r][c];
        }
        
        return dp[r][c];
    }
}
