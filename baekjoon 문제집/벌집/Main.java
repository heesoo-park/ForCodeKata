import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int cur = 1;
        int i = 6;
        int cnt = 1;
        while (true) {
            if (cur >= n) break;
            
            cur += i;
            i += 6;
            cnt++;
        }
        
        System.out.println(cnt);
    }
}
