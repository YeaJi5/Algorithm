import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int result = 0;
    static int[][][] field;
    static boolean[][][] visited;

    static Queue<Tomato> t = new ArrayDeque<>();

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Coord{
        int i, j, k, day;

        private Coord(int i, int j, int k, int day){
            this.i = i;
            this.j = j;
            this.k = k;
            this.day = day;
        }
    }

    static class Tomato{
        int i, j, k;

        private Tomato(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    private static boolean checkTomato(){
        for (int k=0; k<H; k++){
            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    // 익지 않은 토마토가 있으면
                    if (field[i][j][k] == 0) return true;
                }
            }
        }

        return false;
    }

    // -1: 토마토가 없음
    // 0: 익지 않은 토마토
    // 1: 익은 토마토
    private static int bfs(){
        Queue<Coord> q = new ArrayDeque<>();

        while(!t.isEmpty()){
            Tomato tomato = t.poll();

            int si = tomato.i;
            int sj = tomato.j;
            int sk = tomato.k;

            q.add(new Coord(si, sj, sk, 0));
            visited[si][sj][sk] = true;
        }

        while(!q.isEmpty()){
            Coord cor = q.poll();

            int ci = cor.i;
            int cj = cor.j;
            int ck = cor.k;
            int day = cor.day;

            // 같은 높이에서 4방향 탐색
            for (int d=0; d<4; d++){
                int ti = ci + di[d];
                int tj = cj + dj[d];

                if (ti<0 || ti >= N || tj<0 || tj>=M) continue;

                if (visited[ti][tj][ck]) continue;

                // 토마토가 익지 않은 상태였다면 토마토를 익히고 큐에 다시 넣음
                if (field[ti][tj][ck] == 0) {
                    field[ti][tj][ck] = 1;
                    visited[ti][tj][ck] = true;
                    q.add(new Coord(ti, tj, ck, day+1));
                }
            }

            // 위 아래 탐색
            int tk = ck + 1;
            if (tk < H){
                if (!visited[ci][cj][tk]){
                    if (field[ci][cj][tk] == 0){
                        field[ci][cj][tk] = 1;
                        q.add(new Coord(ci, cj, tk, day+1));
                    } else if (field[ci][cj][tk] == 1){
                        visited[ci][cj][tk] = true;
                    }
                }
            }

            int bk = ck - 1;
            if (bk >= 0){
                if (!visited[ci][cj][bk]){
                    if (field[ci][cj][bk] == 0){
                        field[ci][cj][bk] = 1;
                        q.add(new Coord(ci, cj, bk, day+1));
                    } else if (field[ci][cj][bk] == 1){
                        visited[ci][cj][bk] = true;
                    }
                }
            }

            result = Math.max(day, result);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        field = new int[N][M][H];
        visited = new boolean[N][M][H];

        for (int k=0; k<H; k++){
            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<M; j++){
                    field[i][j][k] = Integer.parseInt(st.nextToken());

                    if (field[i][j][k] == 1){
                        t.add(new Tomato(i, j, k));
                    }
                }
            }
        }

        bfs();

        if (checkTomato()){
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
