import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] field;
    static boolean[][][] visited;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Coord{
        int i, j, b, c;

        private Coord(int i, int j, int b, int c){
            this.i = i;
            this.j = j;
            this.b = b;
            this.c = c;
        }
    }

    private static int bfs(int si, int sj, int b){
        Queue<Coord> q = new ArrayDeque<>();

        int cnt = 1;

        visited[si][sj][b] = true;
        q.add(new Coord(si, sj, b, cnt));

        while(!q.isEmpty()) {
            Coord cor = q.poll();
            int ti = cor.i;
            int tj = cor.j;
            int tb = cor.b;
            int tc = cor.c;

            if(ti == N && tj ==M) {
                return tc;
            }

            for (int d=0; d<4; d++){
                int ci = ti + di[d];
                int cj = tj + dj[d];

                // 범위를 벗어나면
                if (ci<=0 || ci>N || cj<=0 || cj>M) continue;

                // 이미 방문했던 위치라면?
                if (visited[ci][cj][tb]) continue;

                // 해당 칸이 벽이면??
                if (field[ci][cj] == 1) {

                    if (tb == K) continue;

                    if(visited[ci][cj][tb+1]) continue;

                    visited[ci][cj][tb+1] = true;

                    q.add(new Coord(ci, cj, tb+1, tc+1));

                } else {
                    visited[ci][cj][tb] = true;
                    q.add(new Coord(ci, cj, tb, tc+1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        field = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][K+1];

        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for (int j=1; j<=M; j++){
                field[i][j] = str.charAt(j-1) - '0';
            }
        }

        System.out.println(bfs(1, 1, 0));

    }
}
