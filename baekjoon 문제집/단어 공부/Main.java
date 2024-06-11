import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] chars = new int[26];
        
        String word = br.readLine().toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            chars[word.charAt(i) - 'A']++;
        }
        
        int max = -1;
        int maxIdx = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > max) {
                max = chars[i];
                maxIdx = i;
            }
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == max && maxIdx != i) {
                System.out.println("?");
                return;
            }
        }
        
        System.out.println((char)(maxIdx + 'A'));
    }
}
