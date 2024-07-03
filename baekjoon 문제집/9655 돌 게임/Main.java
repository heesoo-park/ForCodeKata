// DP를 활용한 코드
import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[] dp = new boolean[1001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        dp[1] = true;
        dp[3] = true;
        for (int i = 4; i <= n; i++) {
            dp[i] = (i % 3 == 0) ? !dp[i - 3] : !dp[i - 1];
        }
        
        System.out.print(dp[n] ? "SK" : "CY");
    }
}

// 숫자 자체를 활용한 코드
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        System.out.print(n % 2 == 0 ? "CY" : "SK");
    }
}
