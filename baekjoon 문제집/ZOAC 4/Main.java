import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int rowCnt = (h % (n + 1) != 0) ? (h / (n + 1) + 1) : (h / (n + 1));
        int colCnt = (w % (m + 1) != 0) ? (w / (m + 1) + 1) : (w / (m + 1));
        
        bw.write(rowCnt * colCnt + "\n");
        bw.flush();
        bw.close();
    }
}
