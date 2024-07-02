import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] paper = new boolean[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int m, n;
    static LinkedList<Integer> ll = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            fillPaper(leftX, leftY, rightX, rightY);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!paper[i][j] && !visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        bw.write(cnt + "\n");
        Collections.sort(ll);
        for (int num : ll) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int sr, int sc) {
        Queue<Position> q = new LinkedList<>();
        int area = 1;
        visited[sr][sc] = true;
        q.offer(new Position(sr, sc));

        while (!q.isEmpty()) {
            Position cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dy[i];
                int nc = cur.c + dx[i];

                if (nr >= m || nr < 0 || nc >= n || nc < 0) continue;
                if (paper[nr][nc] || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                area++;
                q.offer(new Position(nr, nc));
            }
        }

        ll.offer(area);
    }

    static void fillPaper(int lx, int ly, int rx, int ry) {
        for (int i = ly; i < ry; i++) {
            for (int j = lx; j < rx; j++) {
                paper[i][j] = true;
            }
        }
    }

    static class Position {
        int r;
        int c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
