import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            
            if (one == 0 && two == 0 && three == 0) break;
            
            int[] arr = {one, two, three};
            Arrays.sort(arr);
                        
            if (arr[2] < arr[0] + arr[1]) {
                if (one == two && two == three) {
                    sb.append("Equilateral");
                } else if (one == two || two == three || three == one) {
                    sb.append("Isosceles");
                } else {
                    sb.append("Scalene");
                }
            } else {
                sb.append("Invalid");
            }
            
            sb.append('\n');
        }
        
        System.out.println(sb);
    }
}
